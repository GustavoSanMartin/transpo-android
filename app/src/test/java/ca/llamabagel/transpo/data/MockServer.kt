/*
 * Copyright (c) 2019 Derek Ellis. Subject to the MIT license.
 */

package ca.llamabagel.transpo.data

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

fun createMockServer(): MockWebServer {
    val server = MockWebServer()
    server.dispatcher = dispatcher

    return server
}

private val dispatcher = object : Dispatcher() {
    override fun dispatch(request: RecordedRequest?): MockResponse = when (request?.path) {
        "/trips/7225" -> MockResponse().setResponseCode(200).setBody(
            """
            {"stopCode":"7225","routes":[{"number":"44","directionId":1,"direction":"Northbound","heading":"Gatineau","trips":[{"destination":"Terrasses de la Chaudière","startTime":"23:20","adjustedScheduleTime":9,"adjustmentAge":0.15,"lastTripOfSchedule":false,"busType":"H","hasBikeRack":false,"punctuality":0,"latitude":45.371135,"longitude":-75.661478,"gpsSpeed":47.8},{"destination":"Terrasses de la Chaudière","startTime":"23:50","adjustedScheduleTime":39,"adjustmentAge":-2.0,"lastTripOfSchedule":true,"busType":"H","hasBikeRack":false,"punctuality":0}]},{"number":"112","directionId":1,"direction":"Westbound","heading":"Billings Bridge","trips":[{"destination":"Billings Bridge","startTime":"23:33","adjustedScheduleTime":20,"adjustmentAge":3.65,"lastTripOfSchedule":true,"busType":"","hasBikeRack":false,"punctuality":0,"latitude":45.399238,"longitude":-75.623216,"gpsSpeed":53.4}]}],"inactiveRoutes":[],"responseTime":"Jun 12, 2019 3:25:08 AM"}
            """.trimIndent()
        )
        "/trips/3000" -> MockResponse().setResponseCode(200).setBody(
            """
                {"stopCode":"3000","routes":[{"number":"19","directionId":0,"direction":"Westbound","heading":"Parliament / Parlement","trips":[{"destination":"Parliament / Parlement","startTime":"23:15","adjustedScheduleTime":10,"adjustmentAge":0.1,"lastTripOfSchedule":false,"busType":"H","hasBikeRack":false,"punctuality":0,"latitude":45.436582,"longitude":-75.661583,"gpsSpeed":41.1},{"destination":"Parliament / Parlement","startTime":"22:15","adjustedScheduleTime":40,"adjustmentAge":-1.0,"lastTripOfSchedule":true,"busType":"L","hasBikeRack":true,"punctuality":0}]},{"number":"19","directionId":1,"direction":"Eastbound","heading":"St-Laurent","trips":[{"destination":"St-Laurent","startTime":"23:38","adjustedScheduleTime":13,"adjustmentAge":-1.0,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0},{"destination":"St-Laurent","startTime":"24:08","adjustedScheduleTime":43,"adjustmentAge":-1.0,"lastTripOfSchedule":true,"busType":"H","hasBikeRack":false,"punctuality":0}]},{"number":"44","directionId":0,"direction":"Southbound","heading":"Billings Bridge","trips":[{"destination":"Billings Bridge","startTime":"23:16","adjustedScheduleTime":6,"adjustmentAge":0.29,"lastTripOfSchedule":false,"busType":"H","hasBikeRack":false,"punctuality":0,"latitude":45.416547,"longitude":-75.706254,"gpsSpeed":44.5},{"destination":"Billings Bridge","startTime":"23:48","adjustedScheduleTime":32,"adjustmentAge":-1.0,"lastTripOfSchedule":false,"busType":"","hasBikeRack":false,"punctuality":0},{"destination":"Billings Bridge","startTime":"24:16","adjustedScheduleTime":63,"adjustmentAge":-1.0,"lastTripOfSchedule":false,"busType":"","hasBikeRack":false,"punctuality":0}]},{"number":"44","directionId":1,"direction":"Northbound","heading":"Gatineau","trips":[{"destination":"Terrasses de la Chaudière","startTime":"23:20","adjustedScheduleTime":27,"adjustmentAge":0.1,"lastTripOfSchedule":false,"busType":"H","hasBikeRack":false,"punctuality":0,"latitude":45.373045,"longitude":-75.648414,"gpsSpeed":19.2},{"destination":"Terrasses de la Chaudière","startTime":"23:50","adjustedScheduleTime":58,"adjustmentAge":-2.0,"lastTripOfSchedule":true,"busType":"H","hasBikeRack":false,"punctuality":0}]},{"number":"61","directionId":0,"direction":"Eastbound","heading":"St-Laurent","trips":[{"destination":"St-Laurent","startTime":"22:47","adjustedScheduleTime":6,"adjustmentAge":0.4,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.41423,"longitude":-75.709519,"gpsSpeed":24.6},{"destination":"St-Laurent","startTime":"22:39","adjustedScheduleTime":23,"adjustmentAge":0.17,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.35877,"longitude":-75.771597,"gpsSpeed":38.9},{"destination":"St-Laurent","startTime":"23:09","adjustedScheduleTime":41,"adjustmentAge":0.37,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.310145,"longitude":-75.905898,"gpsSpeed":23.5}]},{"number":"61","directionId":1,"direction":"Westbound","heading":"Terry Fox","trips":[{"destination":"Terry Fox","startTime":"23:29","adjustedScheduleTime":23,"adjustmentAge":-2.0,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0},{"destination":"Terry Fox","startTime":"24:00","adjustedScheduleTime":54,"adjustmentAge":-1.0,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0},{"destination":"Terry Fox","startTime":"24:24","adjustedScheduleTime":78,"adjustmentAge":-1.0,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0}]},{"number":"62","directionId":0,"direction":"Eastbound","heading":"St-Laurent","trips":[{"destination":"St-Laurent","startTime":"23:16","adjustedScheduleTime":33,"adjustmentAge":0.49,"lastTripOfSchedule":false,"busType":"S","hasBikeRack":true,"punctuality":0,"latitude":45.320514,"longitude":-75.884309,"gpsSpeed":32.4},{"destination":"St-Laurent","startTime":"23:47","adjustedScheduleTime":61,"adjustmentAge":0.47,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.309574,"longitude":-75.906899,"gpsSpeed":0.5}]},{"number":"62","directionId":1,"direction":"Westbound","heading":"Stittsville","trips":[{"destination":"Terry Fox","startTime":"23:14","adjustedScheduleTime":10,"adjustmentAge":0.09,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.411749,"longitude":-75.665681,"gpsSpeed":31.3},{"destination":"Terry Fox","startTime":"23:44","adjustedScheduleTime":38,"adjustmentAge":-1.0,"lastTripOfSchedule":true,"busType":"L","hasBikeRack":true,"punctuality":0}]},{"number":"85","directionId":1,"direction":"Westbound","heading":"Bayshore","trips":[{"destination":"Bayshore","startTime":"23:22","adjustedScheduleTime":4,"adjustmentAge":0.39,"lastTripOfSchedule":false,"busType":"S","hasBikeRack":false,"punctuality":0,"latitude":45.421751,"longitude":-75.679922,"gpsSpeed":14.8},{"destination":"Bayshore","startTime":"23:52","adjustedScheduleTime":34,"adjustmentAge":5.19,"lastTripOfSchedule":false,"busType":"S","hasBikeRack":false,"punctuality":0,"latitude":45.416319,"longitude":-75.669255,"gpsSpeed":2.7},{"destination":"Bayshore","startTime":"22:07","adjustedScheduleTime":65,"adjustmentAge":-1.0,"lastTripOfSchedule":true,"busType":"S","hasBikeRack":false,"punctuality":0}]},{"number":"86","directionId":0,"direction":"Eastbound","heading":"Elmvale","trips":[{"destination":"Elmvale","startTime":"23:02","adjustedScheduleTime":8,"adjustmentAge":0.84,"lastTripOfSchedule":false,"busType":"H","hasBikeRack":false,"punctuality":0,"latitude":45.407181,"longitude":-75.726135,"gpsSpeed":46.7},{"destination":"Elmvale","startTime":"23:32","adjustedScheduleTime":38,"adjustmentAge":-2.0,"lastTripOfSchedule":true,"busType":"S","hasBikeRack":true,"punctuality":0}]},{"number":"86","directionId":1,"direction":"Westbound","heading":"Baseline","trips":[{"destination":"Baseline","startTime":"23:24","adjustedScheduleTime":23,"adjustmentAge":0.15,"lastTripOfSchedule":false,"busType":"","hasBikeRack":false,"punctuality":0,"latitude":45.399166,"longitude":-75.623166,"gpsSpeed":0.5},{"destination":"Baseline","startTime":"23:54","adjustedScheduleTime":54,"adjustmentAge":-1.0,"lastTripOfSchedule":true,"busType":"H","hasBikeRack":false,"punctuality":0}]},{"number":"94","directionId":0,"direction":"Westbound","heading":"Riverview","trips":[{"destination":"Tunney\u0027s Pasture","startTime":"23:01","adjustedScheduleTime":17,"adjustmentAge":0.19,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.423102,"longitude":-75.597749,"gpsSpeed":46.7},{"destination":"Tunney\u0027s Pasture","startTime":"23:31","adjustedScheduleTime":46,"adjustmentAge":0.25,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":false,"punctuality":0,"latitude":45.465268,"longitude":-75.448211,"gpsSpeed":0.5},{"destination":"Tunney\u0027s Pasture","startTime":"24:01","adjustedScheduleTime":76,"adjustmentAge":-1.0,"lastTripOfSchedule":true,"busType":"N","hasBikeRack":false,"punctuality":0}]},{"number":"94","directionId":1,"direction":"Eastbound","heading":"Millennium","trips":[{"destination":"Millennium","startTime":"23:21","adjustedScheduleTime":8,"adjustmentAge":1.67,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.407889,"longitude":-75.724439,"gpsSpeed":42.2},{"destination":"Millennium","startTime":"23:51","adjustedScheduleTime":36,"adjustmentAge":0.2,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.404062,"longitude":-75.736154,"gpsSpeed":0.5},{"destination":"Millennium","startTime":"24:21","adjustedScheduleTime":66,"adjustmentAge":-1.0,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0}]},{"number":"95","directionId":0,"direction":"Eastbound","heading":"Orléans","trips":[{"destination":"Trim","startTime":"22:47","adjustedScheduleTime":17,"adjustmentAge":0.27,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.392512,"longitude":-75.759912,"gpsSpeed":45.6},{"destination":"Trim","startTime":"23:13","adjustedScheduleTime":26,"adjustmentAge":0.12,"lastTripOfSchedule":false,"busType":"S","hasBikeRack":true,"punctuality":0,"latitude":45.343525,"longitude":-75.757475,"gpsSpeed":47.8},{"destination":"Place d\u0027Orléans","startTime":"23:34","adjustedScheduleTime":46,"adjustmentAge":0.49,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.266886,"longitude":-75.741539,"gpsSpeed":0.5}]},{"number":"95","directionId":1,"direction":"Westbound","heading":"Barrhaven Centre","trips":[{"destination":"Barrhaven Centre","startTime":"22:48","adjustedScheduleTime":2,"adjustmentAge":0.12,"lastTripOfSchedule":false,"busType":"S","hasBikeRack":false,"punctuality":0,"latitude":45.424609,"longitude":-75.687088,"gpsSpeed":1.6},{"destination":"Barrhaven Centre","startTime":"23:03","adjustedScheduleTime":7,"adjustmentAge":0.34,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.41916,"longitude":-75.6542,"gpsSpeed":51.1},{"destination":"Barrhaven Centre","startTime":"23:18","adjustedScheduleTime":25,"adjustmentAge":0.19,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":false,"punctuality":0,"latitude":45.469473,"longitude":-75.546979,"gpsSpeed":36.7}]},{"number":"97","directionId":0,"direction":"Eastbound","heading":"Airport / Aéroport","trips":[{"destination":"Airport / Aéroport","startTime":"22:40","adjustedScheduleTime":4,"adjustmentAge":0.35,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.418202,"longitude":-75.702397,"gpsSpeed":21.3},{"destination":"Airport / Aéroport","startTime":"23:19","adjustedScheduleTime":30,"adjustmentAge":0.19,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.348543,"longitude":-75.807078,"gpsSpeed":0.5},{"destination":"Airport / Aéroport","startTime":"23:16","adjustedScheduleTime":40,"adjustmentAge":0.15,"lastTripOfSchedule":false,"busType":"S","hasBikeRack":true,"punctuality":0,"latitude":45.327989,"longitude":-75.818874,"gpsSpeed":59.9}]},{"number":"97","directionId":1,"direction":"Westbound","heading":"Bells Corners","trips":[{"destination":"Bayshore","startTime":"23:02","adjustedScheduleTime":5,"adjustmentAge":0.24,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.420501,"longitude":-75.678854,"gpsSpeed":23.5},{"destination":"Bayshore","startTime":"23:17","adjustedScheduleTime":20,"adjustmentAge":0.57,"lastTripOfSchedule":false,"busType":"L","hasBikeRack":true,"punctuality":0,"latitude":45.361706,"longitude":-75.660596,"gpsSpeed":51.1},{"destination":"Bayshore","startTime":"23:32","adjustedScheduleTime":32,"adjustmentAge":0.49,"lastTripOfSchedule":false,"busType":"S","hasBikeRack":true,"punctuality":0,"latitude":45.322277,"longitude":-75.66586,"gpsSpeed":0.5}]}],"inactiveRoutes":[],"responseTime":"Jun 12, 2019 3:28:08 AM"}
            """.trimIndent()
        )
        else -> MockResponse().setResponseCode(404)
    }.addHeader("Content-Type", "application/json; charset=utf-8")
}