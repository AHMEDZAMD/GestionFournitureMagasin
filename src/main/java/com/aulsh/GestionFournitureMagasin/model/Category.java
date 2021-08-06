package com.aulsh.GestionFournitureMagasin.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category extends AbstractEntity{



      @Column(name = "code")
      private String code;

      @Column(name = "designation")
      private String designation;

      @OneToMany(mappedBy = "category")
      private List<Article> articles ;
}
