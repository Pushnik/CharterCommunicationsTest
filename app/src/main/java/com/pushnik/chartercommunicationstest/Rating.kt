package com.pushnik.chartercommunicationstest

import com.google.gson.annotations.SerializedName

/*
  {
    "dbn":"07X547",
    "num_of_sat_test_takers":"28",
    "sat_critical_reading_avg_score":"367",
    "sat_math_avg_score":"356",
    "sat_writing_avg_score":"361",
    "school_name":"NEW EXPLORERS HIGH SCHOOL"
  }
* */

class Rating {
    var dbn: String? = null
    @SerializedName("num_of_sat_test_takers")
    var numOfSatTestTakers: String? = null
    @SerializedName("sat_critical_reading_avg_score")
    var satCriticalReadingAvgScore: String? = null
    @SerializedName("sat_math_avg_score")
    var satMathAvgScore: String? = null
    @SerializedName("sat_writing_avg_score")
    var satWritingAvgScore: String? = null
    @SerializedName("school_name")
    var schoolName: String? = null

}