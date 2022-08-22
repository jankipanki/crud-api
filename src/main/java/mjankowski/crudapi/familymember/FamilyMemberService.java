package mjankowski.crudapi.familymember;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyMemberService {
    private FamilyMemberDtoMapper familyMemberDtoMapper;
    private FamilyMemberRepository familyMemberRepository;

    public FamilyMemberService(FamilyMemberDtoMapper familyMemberDtoMapper, FamilyMemberRepository familyMemberRepository) {
        this.familyMemberDtoMapper = familyMemberDtoMapper;
        this.familyMemberRepository = familyMemberRepository;
    }

    Optional<FamilyMemberDto> getFamilyMemberById(Long id) {
        return familyMemberRepository.findById(id).map(familyMemberDtoMapper::map);
    }
}
