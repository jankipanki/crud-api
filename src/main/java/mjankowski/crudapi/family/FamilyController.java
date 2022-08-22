package mjankowski.crudapi.family;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping("/family/{id}")
    ResponseEntity<FamilyDto> getFamilyById(@PathVariable Long id) {
        return familyService.getFamilyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        //30:37
    }

    @PostMapping("/family")
    ResponseEntity<FamilyDto> savedFamily(@RequestBody FamilyDto family) {
        FamilyDto savedFamily = familyService.savedFamily(family);
        URI saveFamilyUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedFamily.getId())
                .toUri();
        return ResponseEntity.created(saveFamilyUri).body(savedFamily);
    }

    /*@PutMapping("/family/{id}")
    ResponseEntity<?> replaceFamily(@PathVariable Long id, @RequestBody FamilyDto family) {
        return familyService.replaceFamily(id, family)
                .map(f -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }*/

    @PatchMapping("/family/{id}")
    ResponseEntity<?> updateFamily(@PathVariable Long id, @RequestBody FamilyDto familyDto) {
        return familyService.updateFamily(id, familyDto)
                .map(offer -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/family/{id}")
    ResponseEntity<?> deleteFamily(@PathVariable Long id) {
        familyService.deleteFamily(id);
        return ResponseEntity.noContent().build();
    }


}
