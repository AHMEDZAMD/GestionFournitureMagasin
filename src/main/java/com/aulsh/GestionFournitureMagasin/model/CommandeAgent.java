package com.aulsh.GestionFournitureMagasin.model;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
@Table(name = "commandeagent")
public class CommandeAgent extends AbstractEntity{


    @Column(name = "code")
    private String code;
    @Column(name = "datacommande")
    private Instant dateCommande;


    @OneToMany(mappedBy = "commandeAgent")
    private List<LigneCmdeAgent> ligneCmdeAgents;



    @ManyToOne
    @JoinColumn(name = "idAgent")
    private Agent agent;
}
