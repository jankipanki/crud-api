package mjankowski.crudapi.family;

import org.springframework.stereotype.Service;

@Service
public class FamilyDtoMapper {
    FamilyDto map(Family family) {
        FamilyDto dto = new FamilyDto();
        dto.setId(family.getId());
        dto.setFamilyName(family.getFamilyName());
        dto.setNrOfAdults(family.getNrOfAdults());
        dto.setNrOfChildren(family.getNrOfChildren());
        dto.setNrOfInfants(family.getNrOfInfants());
        return dto;
    }

    Family map(FamilyDto dto) {
        Family family = new Family();
        family.setId(dto.getId());
        family.setFamilyName(dto.getFamilyName());
        family.setNrOfAdults(dto.getNrOfAdults());
        family.setNrOfChildren(dto.getNrOfChildren());
        family.setNrOfInfants(dto.getNrOfInfants());
        return family;
    }
}
