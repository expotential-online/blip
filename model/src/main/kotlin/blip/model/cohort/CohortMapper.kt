package blip.model.cohort

import blip.model.Mapper

object CohortMapper : Mapper<CohortDto, Cohort> {
  override fun toModel(dto: CohortDto): Cohort = with(dto) {
    Cohort(name)
  }
}