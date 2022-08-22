package mjankowski.crudapi.familymember;

import org.springframework.stereotype.Service;

@Service
public class FamilyMemberDtoMapper {
    FamilyMemberDto map(FamilyMember familyMember) {
        FamilyMemberDto dto = new FamilyMemberDto();
        dto.setId(familyMember.getId());
        dto.setFamilyId(familyMember.getFamilyId());
        dto.setFamilyName(familyMember.getFamilyName());
        dto.setGivenName(familyMember.getGivenName());
        return dto;
    }
}
