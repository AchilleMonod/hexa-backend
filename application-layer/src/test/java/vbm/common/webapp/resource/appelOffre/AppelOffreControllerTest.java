package vbm.common.webapp.resource.appelOffre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import vbm.common.model.AppelOffreBO;
import vbm.common.model.BureauEtudeBO;
import vbm.common.service.AppelOffreService;
import vbm.common.exception.AppelOffreServiceException;
import vbm.common.webapp.mapper.BureauEtudeMapper;
import vbm.common.webapp.model.BureauEtudeDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.test.context.support.WithMockUser;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AppelOffreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AppelOffreService appelOffreService;

    @MockitoBean
    private BureauEtudeMapper bureauEtudeMapper;

    @Autowired
    private ObjectMapper objectMapper;

    private BureauEtudeDTO bureauEtudeDTO;
    private BureauEtudeBO bureauEtudeBO;
    private AppelOffreBO appelOffreBO;

    @BeforeEach
    void setUp() {
        bureauEtudeDTO = BureauEtudeDTO.builder().id(1L).nom("Bureau").description("Desc").build();
        bureauEtudeBO = BureauEtudeBO.builder().id(1L).nom("Bureau").description("Desc").build();
        appelOffreBO = AppelOffreBO.builder().id(1L).nom("Appel").description("Desc").build();
    }

    @Test
    @WithMockUser
    void testGetAllAppelOffre_Success() throws Exception {
        when(bureauEtudeMapper.map(any())).thenReturn(bureauEtudeBO);
        when(appelOffreService.getAllAppelOffre(any())).thenReturn(List.of(appelOffreBO));

        mockMvc.perform(get("/appelOffre")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bureauEtudeDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L));
    }

    @Test
    @WithMockUser
    void testGetAllAppelOffre_EmptyList() throws Exception {
        when(bureauEtudeMapper.map(any())).thenReturn(bureauEtudeBO);
        when(appelOffreService.getAllAppelOffre(any())).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/appelOffre")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bureauEtudeDTO)))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser
    void testGetAllAppelOffre_Exception() throws Exception {
        when(bureauEtudeMapper.map(any())).thenReturn(bureauEtudeBO);
        when(appelOffreService.getAllAppelOffre(any()))
                .thenThrow(new AppelOffreServiceException("Erreur"));

        mockMvc.perform(get("/appelOffre")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bureauEtudeDTO)))
                .andExpect(status().isBadRequest());
    }
}