package blip.archive.model.cohort

import blip.core.CohortId
import blip.core.CohortName
import blip.core.Identifiable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Cohort(

  var name: CohortName?,

  @Id
  @GeneratedValue
  override var id: CohortId? = null
) : Identifiable<CohortId>