package mjankowski.crudapi.family;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FamilyService {
    private FamilyRepository familyRepository;
    private FamilyDtoMapper familyDtoMapper;

    public FamilyService(FamilyRepository familyRepository, FamilyDtoMapper familyDtoMapper) {
        this.familyRepository = familyRepository;
        this.familyDtoMapper = familyDtoMapper;
    }

    Optional<FamilyDto> getFamilyById(Long id) {
        return familyRepository.findById(id).map(familyDtoMapper::map);
    }

    FamilyDto savedFamily(FamilyDto familyDto) {
        Family family = familyDtoMapper.map(familyDto);
        Family savedFamily = familyRepository.save(family);
        return familyDtoMapper.map(savedFamily);
    }

    /*Optional<FamilyDto> replaceFamily(Long familyId, FamilyDto familyDto) {
        if (!familyRepository.existsById(familyId)) {
            return Optional.empty();
        }
        familyDto.setId(familyId);
        Family familyToUpdate = familyDtoMapper.map(familyDto);
        Family updateEntity = familyRepository.save(familyToUpdate);
        return Optional.of(familyDtoMapper.map(updateEntity));
    }*/

    @Transactional
    public Optional<FamilyDto> updateFamily(Long id, FamilyDto familyDto) {
        return familyRepository.findById(id)
                .map(target -> setEntityFields(familyDto, target))
                .map(familyDtoMapper::map);
    }

    public void deleteFamily(Long id) {
        familyRepository.deleteById(id);
    }

    private Family setEntityFields(FamilyDto source, Family target) {
        if (source.getFamilyName()  != null) {
            target.setFamilyName(source.getFamilyName());
        }

        if (source.getNrOfAdults() != 0) {
            target.setNrOfAdults(source.getNrOfAdults());
        }

        if (source.getNrOfChildren()  != 0) {
            target.setNrOfChildren(source.getNrOfChildren());
        }

        if (source.getNrOfInfants()  != 0) {
            target.setNrOfInfants(source.getNrOfInfants());
        }
        return target;
    }
}
