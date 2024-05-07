package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.domain.Flor;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.dto.FlorDTO;
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
        return webClient.post()
                .uri("/flower/add")
                .bodyValue(flor)
                .retrieve()
                .bodyToMono(FlorDTO.class)
                .block();
    }


    @Override
    public FlorDTO saveFlower(Flor flor) {
        if (flor.getPk_FlorID() == null) {
            return addFlower(flor);
        } else {
            return webClient.put()
                    .uri("/flower/update")
                    .bodyValue(flor)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .block();
        }
    }

    @Override
    public void deleteFlower(Integer id) {

        webClient.delete()
                .uri("/flower/delete")
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public FlorDTO getOneFlowerDTO(Integer id) {
        return webClient.get()
                .uri("/flower/getOneFlower/{id}",id)
                .retrieve()
                .bodyToMono(FlorDTO.class)
                .block();
    }


    @Override
    public String getAllFlowers() {
        return webClient.get()
                .uri("/flower/getAll")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private  FlorDTO convertToDTO(Flor flor) {
        return new FlorDTO(flor.getPk_FlorID(), flor.getNameFlor(), flor.getPaisFlor());
    }
}
