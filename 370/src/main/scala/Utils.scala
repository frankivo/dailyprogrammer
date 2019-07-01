object Utils {

  implicit class LongUtils(value: Long) {
    def fill(): String = f"$value%011d"

    def toIntList: List[Int] = value.toString.toList.map(_.asDigit)
  }

  implicit class StringUtils(value: String) {
    def toIntList: List[Int] = value.toList.map(_.asDigit)
  }

}
