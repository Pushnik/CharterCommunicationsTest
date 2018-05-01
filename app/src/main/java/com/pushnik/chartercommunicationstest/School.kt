package com.pushnik.chartercommunicationstest

import com.google.gson.annotations.SerializedName
/*
{
  "academicopportunities1":"Free college courses at neighboring universities",
  "academicopportunities2":"International Travel, Special Arts Programs, Music, Internships, College Mentoring English Language Learner Programs: English as a New Language",
  "admissionspriority11":"Priority to continuing 8th graders",
  "admissionspriority21":"Then to Manhattan students or residents",
  "admissionspriority31":"Then to New York City residents",
  "attendance_rate":"0.970000029",
  "bbl":"1008420034",
  "bin":"1089902",
  "boro":"M",
  "borough":"MANHATTAN",
  "building_code":"M868",
  "bus":"BM1, BM2, BM3, BM4, BxM10, BxM6, BxM7, BxM8, BxM9, M1, M101, M102, M103, M14A, M14D, M15, M15-SBS, M2, M20, M23, M3, M5, M7, M8, QM21, X1, X10, X10B, X12, X14, X17, X2, X27, X28, X37, X38, X42, X5, X63, X64, X68, X7, X9",
  "census_tract":"52",
  "city":"Manhattan",
  "code1":"M64A",
  "community_board":"5",
  "council_district":"2",
  "dbn":"02M260",
  "directions1":"See theclintonschool.net for more information.",
  "ell_programs":"English as a New Language",
  "extracurricular_activities":"CUNY College Now, Technology, Model UN, Student Government, School Leadership Team, Music, School Musical, National Honor Society, The Clinton Post (School Newspaper), Clinton Soup (Literary Magazine), GLSEN, Glee",
  "fax_number":"212-524-4365",
  "finalgrades":"6-12",
  "grade9geapplicants1":"1515",
  "grade9geapplicantsperseat1":"19",
  "grade9gefilledflag1":"Y",
  "grade9swdapplicants1":"138",
  "grade9swdapplicantsperseat1":"9",
  "grade9swdfilledflag1":"Y",
  "grades2018":"6-11",
  "interest1":"Humanities & Interdisciplinary",
  "latitude":"40.73653",
  "location":"10 East 15th Street, Manhattan NY 10003 (40.736526, -73.992727)",
  "longitude":"-73.9927",
  "method1":"Screened",
  "neighborhood":"Chelsea-Union Sq",
  "nta":"Hudson Yards-Chelsea-Flatiron-Union Square                                 ",
  "offer_rate1":"Â—57% of offers went to this group",
  "overview_paragraph":"Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analytically and write creatively. Our arts programming builds on our 25 years of experience in visual, performing arts and music on a middle school level. We partner with New Audience and the Whitney Museum as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.",
  "pct_stu_enough_variety":"0.899999976",
  "pct_stu_safe":"0.970000029",
  "phone_number":"212-524-4360",
  "primary_address_line_1":"10 East 15th Street",
  "program1":"M.S. 260 Clinton School Writers & Artists",
  "requirement1_1":"Course Grades: English (87-100), Math (83-100), Social Studies (90-100), Science (88-100)",
  "requirement2_1":"Standardized Test Scores: English Language Arts (2.8-4.5), Math (2.8-4.5)",
  "requirement3_1":"Attendance and Punctuality",
  "requirement4_1":"Writing Exercise",
  "requirement5_1":"Group Interview (On-Site)",
  "school_10th_seats":"1",
  "school_accessibility_description":"1",
  "school_email":"admissions@theclintonschool.net",
  "school_name":"Clinton School Writers & Artists, M.S. 260",
  "school_sports":"Cross Country, Track and Field, Soccer, Flag Football, Basketball",
  "seats101":"YesÂ–9",
  "seats9ge1":"80",
  "seats9swd1":"16",
  "state_code":"NY",
  "subway":"1, 2, 3, F, M to 14th St - 6th Ave; 4, 5, L, Q to 14th St-Union Square; 6, N, R to 23rd St",
  "total_students":"376",
  "website":"www.theclintonschool.net",
  "zip":"10003"
}
* */

class School {
//    var academicopportunities1: String? = null
//    var academicopportunities2: String? = null
//    var admissionspriority11: String? = null
//    var admissionspriority21: String? = null
//    var admissionspriority31: String? = null
//    @SerializedName("attendance_rate")
//    var attendanceRate: String? = null
//    var bbl: String? = null
//    var bin: String? = null
//    var boro: String? = null
//    var borough: String? = null
//    @SerializedName("building_code")
//    var buildingCode: String? = null
//    var bus: String? = null
//    @SerializedName("census_tract")
//    var censusTract: String? = null
//    var city: String? = null
//    var code1: String? = null
//    @SerializedName("community_board")
//    var communityBoard: String? = null
//    @SerializedName("council_district")
//    var councilDistrict: String? = null
    var dbn: String? = null
//    var directions1: String? = null
//    @SerializedName("ell_programs")
//    var ellPrograms: String? = null
//    @SerializedName("extracurricular_activities")
//    var extracurricularActivities: String? = null
//    @SerializedName("fax_number")
//    var faxNumber: String? = null
//    var finalgrades: String? = null
//    var grade9geapplicants1: String? = null
//    var grade9geapplicantsperseat1: String? = null
//    var grade9gefilledflag1: String? = null
//    var grade9swdapplicants1: String? = null
//    var grade9swdapplicantsperseat1: String? = null
//    var grade9swdfilledflag1: String? = null
//    var grades2018: String? = null
//    var interest1: String? = null
//    var latitude: String? = null
//    var location: String? = null
//    var longitude: String? = null
//    var method1: String? = null
//    var neighborhood: String? = null
//    var nta: String? = null
//    @SerializedName("offer_rate1")
//    var offerRate1: String? = null
//    @SerializedName("overview_paragraph")
//    var overviewParagraph: String? = null
//    @SerializedName("pct_stu_enough_variety")
//    var pctStuEnoughVariety: String? = null
//    @SerializedName("pct_stu_safe")
//    var pctStuSafe: String? = null
    @SerializedName("phone_number")
    var phoneNumber: String? = null
//    @SerializedName("primary_address_line_1")
//    var primaryAddressLine1: String? = null
//    var program1: String? = null
//    @SerializedName("requirement1_1")
//    var requirement1_1: String? = null
//    @SerializedName("requirement2_1")
//    var requirement2_1: String? = null
//    @SerializedName("requirement3_1")
//    var requirement3_1: String? = null
//    @SerializedName("requirement4_1")
//    var requirement4_1: String? = null
//    @SerializedName("requirement5_1")
//    var requirement5_1: String? = null
//    @SerializedName("school_10th_seats")
//    var school10thSeats: String? = null
//    @SerializedName("school_accessibility_description")
//    var schoolAccessibilityDescription: String? = null
//    @SerializedName("school_email")
//    var schoolEmail: String? = null
    @SerializedName("school_name")
    var schoolName: String? = null
//    @SerializedName("school_sports")
//    var schoolSports: String? = null
//    var seats101: String? = null
//    var seats9ge1: String? = null
//    var seats9swd1: String? = null
//    @SerializedName("state_code")
//    var stateCode: String? = null
//    var subway: String? = null
//    @SerializedName("total_students")
//    var totalStudents: String? = null
//    var website: String? = null
//    var zip: String? = null

}