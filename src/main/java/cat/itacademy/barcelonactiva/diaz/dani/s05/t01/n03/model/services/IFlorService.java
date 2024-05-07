package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.domain.Flor;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.dto.FlorDTO;

import java.util.List;

public interface IFlorService {

    FlorDTO addFlower(Flor flor);

    FlorDTO saveFlower(Flor flor);

    void deleteFlower(Integer id);

    FlorDTO getOneFlowerDTO(Integer id);


    String getAllFlowers();
}
