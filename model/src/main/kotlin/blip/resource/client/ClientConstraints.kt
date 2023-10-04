package blip.resource.client

typealias ClientId = Long
typealias ClientName = String
typealias ClientDescription = String

object ClientConstraints {
  private const val ClientNameMinLength = 8
  private const val ClientNameMaxLength = 32
  const val ClientNameRegex = "\\w{$ClientNameMinLength, $ClientNameMaxLength}"
  const val ClientDescriptionMinLength = 8
  const val ClientDescriptionMaxLength = 256
}