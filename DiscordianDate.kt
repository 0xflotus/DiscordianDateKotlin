import java.time.LocalDate

class DiscordianDate {
	val _year: Int
	val _season : Int
	val _yearDay : Int
	val _seasonDay : Int
	val _weekDay : Int
	val _isLeap : Boolean
	val _seasonNames = arrayOf("Chaos", "Discord", "Confusion", "Bureaucracy", "The Aftermath")
	val _holidays = arrayOf("Mungday", "Chaoflux", "St. Tib's Day", "Mojoday", "Discoflux", "Syaday",
			"Confuflux", "Zaraday", "Bureflux", "Maladay", "Afflux")
	val _dayNames = arrayOf("Sweetmorn", "Boomtime", "Pungenday", "Prickle-Prickle", "Setting Orange")
	public final val YEAR_DIFFERENCE = 1166;
	public final val MAX_DAY_OF_SEASON = 73;
	public final val COUNT_DAYS = _dayNames.size;
	
	private constructor (ld: LocalDate) {
		_year = ld.year + YEAR_DIFFERENCE
		_isLeap = ld.isLeapYear
		_yearDay = ld.dayOfYear
		var yd = _yearDay - 1
		if (_isLeap && yd > 59)
			yd--;
		_seasonDay = (yd % MAX_DAY_OF_SEASON) + 1
		_season = (yd / MAX_DAY_OF_SEASON) + 1
		_weekDay = (yd % COUNT_DAYS) + 1
	}
	
	public fun getDayName() : String = _dayNames[_weekDay - 1]
	
	public fun getSeasonName() : String = _seasonNames[_season - 1]
	
	override public fun toString() = "${getDayName()}, ${getSeasonName()} ${_seasonDay}, ${_year}";
	
	companion object {
		@JvmStatic public fun of(year: Int = LocalDate.now().year, month: Int = LocalDate.now().monthValue, dayOfMonth: Int = LocalDate.now().dayOfMonth) : DiscordianDate =  DiscordianDate(LocalDate.of(year, month, dayOfMonth))
	}
}