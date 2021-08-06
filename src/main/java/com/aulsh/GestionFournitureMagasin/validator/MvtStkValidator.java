package com.aulsh.GestionFournitureMagasin.validator;

import com.aulsh.GestionFournitureMagasin.DTO.MvmStockDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

public class MvtStkValidator {

  public static List<String> validate(MvmStockDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner la date du mouvenent");
      errors.add("Veuillez renseigner la quantite du mouvenent");
      errors.add("Veuillez renseigner l'article");
      errors.add("Veuillez renseigner le type du mouvement");

      return errors;
    }
    if (dto.getDateachat() == null) {
      errors.add("Veuillez renseigner la date du mouvenent");
    }
    if (dto.getQuantity() == null || dto.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
      errors.add("Veuillez renseigner la quantite du mouvenent");
    }
    if (dto.getArticle() == null || dto.getArticle().getId() == null) {
      errors.add("Veuillez renseigner l'article");
    }
    if (!StringUtils.hasLength(dto.getTypeMvt().name())) {
      errors.add("Veuillez renseigner le type du mouvement");
    }

    return errors;
  }

}
