package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.domain.Flor;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services.exceptions.FlorList;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services.exceptions.FlorNoCreada;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services.exceptions.FlorNoID;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services.exceptions.FlorNula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class FlorService implements IFlorService {

    @Autowired
    private WebClient webClient;

    @Override
    public FlorDTO addFlower(Flor flor) {
        try {
            return webClient.post()
                    .uri("/webservice/add")
                    .bodyValue(flor)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .block();
        } catch (Exception e) {
            throw new FlorNoCreada();
        }
    }


    @Override
    public FlorDTO saveFlower(Flor flor) {
        try {
            if (flor.getPk_FlorID() == null) {
                return addFlower(flor);
            } else {
                return webClient.put()
                        .uri("/webservice/update")
                        .bodyValue(flor)
                        .retrieve()
                        .bodyToMono(FlorDTO.class)
                        .block();
            }
        } catch (Exception e) {
            throw new FlorNula();
        }
    }

    @Override
    public void deleteFlower(Integer id) {
        try {
            webClient.delete()
                    .uri("/webservice/delete")
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (Exception e) {
            throw new FlorNoID(id);
        }
    }

    @Override
    public FlorDTO getOneFlowerDTO(Integer id) {
        try {
            return webClient.get()
                    .uri("/webservice/getOne/{id}", id)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .block();
        } catch (Exception e) {
            throw new FlorNoID(id);
        }
    }

    public Flor getOne(Integer id) {
        try {
            return webClient.get()
                    .uri("/webservice/getOne/{id}", id)
                    .retrieve()
                    .bodyToMono(Flor.class)
                    .block();
        } catch (Exception e) {
            throw new FlorNoID(id);
        }
    }


    @Override
    public List<FlorDTO> getAllFlowers() {
        try {
            return webClient.get()
                    .uri("/webservice/getAll")
                    .retrieve()
                    .bodyToFlux(FlorDTO.class)
                    .collectList().block();
        } catch (Exception e) {
            throw new FlorList();
        }
    }
}
