package test.packages.pages

object ApiSteps extends BasePage {

  val createUserUrl = "http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com/peps"
  val getPolticiansUrl = "http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com/peps"

  def getPolticiansUrlById(id: String) = s"http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com/peps/${id}"

  val id = ""


//  def insertNewData(): Unit = {
//    val httpResponse: HttpResponse[String] = Http(createUserUrl)
//      .postData(JsonData.politicianData)
//      .header("Content-Type", "application/json")
//      .asString
//
//    httpResponse.code shouldBe 201
//  }
//
//
//  def getLatestFivePoliticians(): Unit = {
//    val httpResponse: HttpResponse[String] = Http(getPolticiansUrl)
//      .asString
//
//    val jsonBody: JsValue = Json.parse(httpResponse.body).as[JsArray]
//    id = (jsonBody(0) \ "applicationReference").get.as[String]
//
//
//    println(s"THE ID OF THE FIRST USER ON THE LIST IS: $id")
//    httpResponse.code shouldBe 200
//
//  }
//
//  def getPolitician(): Unit = {
//    val httpResponse: HttpResponse[String] = Http(getPolticiansUrlById(id))
//      .asString
//
//    httpResponse.code shouldBe 200
//  }

}
