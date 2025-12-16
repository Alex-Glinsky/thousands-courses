interface CoursesApi {
    @GET("uc")
    suspend fun getCourses(
        @Query("id") id: String,
        @Query("export") export: String
    ): CoursesResponse
}