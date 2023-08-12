package blip.model.cohort

import blip.model.CohortId
import blip.model.CohortName
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Cohort(

  var name: CohortName?,

  @Id @GeneratedValue var id: CohortId? = null
)