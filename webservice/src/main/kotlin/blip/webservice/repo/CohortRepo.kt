package blip.webservice.repo

import blip.archive.model.cohort.Cohort
import blip.core.CohortId
import blip.webservice.Repo

interface CohortRepo : Repo<Cohort, CohortId>