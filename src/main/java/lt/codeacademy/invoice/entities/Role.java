package lt.codeacademy.invoice.entities;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "roles")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;

//  public Role(Integer id, ERole name) {
//	 this.id = id;
//    this.name = name;
//  }

}



