package io.github.aj8gh.skeleton.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.aj8gh.skeleton.api.mapper.SkeletonRestMapper;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import io.github.aj8gh.skeleton.service.SkeletonService;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class SkeletonControllerTest {

  private static final String CREATE_PATH = "/skeleton/create";
  private static final String NAME = "name";
  private static final int BONES = 206;
  private static final Instant NOW = Instant.now();
  private static final UUID ID = UUID.randomUUID();

  private MockMvc mockMvc;
  private ObjectMapper objectMapper;

  @Mock
  private SkeletonService service;
  @Mock
  private SkeletonRestMapper mapper;
  @InjectMocks
  private SkeletonController controller;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  void create_HappyPath() throws Exception {
    // Given
    var request = new SkeletonCreateRequest()
        .name(NAME)
        .bones(BONES);

    var modelToCreate = toModel(request);

    var createdModel = modelToCreate.toBuilder()
        .id(ID)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();

    var dto = toDto(createdModel);

    when(mapper.fromCreateRequest(request)).thenReturn(modelToCreate);
    when(service.create(modelToCreate)).thenReturn(createdModel);
    when(mapper.toDto(createdModel)).thenReturn(dto);

    // When
    var actual = mockMvc.perform(post(CREATE_PATH)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().is(201))
        .andReturn()
        .getResponse()
        .getContentAsString();

    // Then
    assertThat(objectMapper.readValue(actual, SkeletonDto.class)).isEqualTo(dto);
  }

  private SkeletonDto toDto(Skeleton model) {
    return new SkeletonDto()
        .name(model.getName())
        .bones(model.getBones())
        .id(model.getId())
        .createdAt(model.getCreatedAt())
        .updatedAt(model.getUpdatedAt());
  }

  private Skeleton toModel(SkeletonCreateRequest request) {
    return Skeleton.builder()
        .name(request.getName())
        .bones(request.getBones())
        .build();
  }
}
