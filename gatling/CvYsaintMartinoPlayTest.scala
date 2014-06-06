
import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import com.excilys.ebi.gatling.http.Headers.Names._
import akka.util.duration._
import bootstrap._
import assertions._

class CvYsaintMartinoPlayTest extends Simulation {

	val httpConf = httpConfig
			.baseURL("http://www.yannick-saintmartino.com")
			.acceptHeader("*/*")
			.acceptEncodingHeader("gzip, deflate")
			.acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
			.connection("keep-alive")
			.doNotTrackHeader("1")
			.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:28.0) Gecko/20100101 Firefox/28.0")


	val headers_1 = Map(
			"Accept" -> """text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"""
	)

	val headers_2 = Map(
			"Accept" -> """text/css,*/*;q=0.1"""
	)

	val headers_6 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"80e3ad2b078895698d0e7f0e7ccf415a117ab2a0""""
	)

	val headers_7 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"62db3a8b236d931fb32cb667199bc90af2a6064f""""
	)

	val headers_8 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"ca2ffceabdf825677c2bb65dfdf033024de3319d""""
	)

	val headers_9 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"ace697c15dcfb83f16e554721c2d9519d1a03199""""
	)

	val headers_11 = Map(
			"If-Modified-Since" -> """Wed, 30 Apr 2014 19:38:04 GMT""",
			"If-None-Match" -> """"e2ca4b53dc4fd58ece796236647d5f93a30831d4""""
	)

	val headers_13 = Map(
			"If-Modified-Since" -> """Sat, 21 Dec 2013 10:45:08 GMT""",
			"If-None-Match" -> """"466ee2bb9d34dfc097a88c2583fc9c4f44037108""""
	)

	val headers_14 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"03b611e2d105afdd415d61540617b852d82057b9""""
	)

	val headers_16 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"1ad60e67d7096f37dadcf719b22647705e2db9a1""""
	)

	val headers_17 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"0ee76ce0a2dae4ef93193d3b9e04394498fadde3""""
	)

	val headers_18 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"454cf3dbb1084e76d4f7e93e35066c7b38b3cf91""""
	)

	val headers_19 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"56fe5173a66417e1caf081659235acbf304c0c04""""
	)

	val headers_20 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"df601c18c86241c2c247d7d3d231cbddbe96e598""""
	)

	val headers_21 = Map(
			"If-Modified-Since" -> """Sat, 21 Dec 2013 10:45:08 GMT""",
			"If-None-Match" -> """"9aad3d95e3067cdf71afc3debbdcb9b0e157412d""""
	)

	val headers_22 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"3b01e168e54bb8a6d38b7d006dcf51fa87e88165""""
	)

	val headers_23 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"850aee92e7553aecae494dbebacf973e69b341d4""""
	)

	val headers_24 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"0dbc903ea3bf8f259032ed37958885fcfb807a06""""
	)

	val headers_25 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"3c0bb1a620b7d5467884a878e089f8a49fd3b2c0""""
	)

	val headers_26 = Map(
			"If-Modified-Since" -> """Fri, 11 Apr 2014 17:27:54 GMT""",
			"If-None-Match" -> """"c2d8a452022a824a1b827764d932add512414751""""
	)

	val headers_27 = Map(
			"If-Modified-Since" -> """Sat, 21 Dec 2013 10:45:08 GMT""",
			"If-None-Match" -> """"a01c40ce097b8d7921394376ad75c34c2eccbef0""""
	)

	val headers_28 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"12afa00b4579b41ebb2acdfb2c636e4aba60f283""""
	)

	val headers_29 = Map(
			"If-Modified-Since" -> """Mon, 28 Apr 2014 13:47:54 GMT""",
			"If-None-Match" -> """"3426225acaed531d57b47f69b7aa82b2c598cc50""""
	)

	val headers_30 = Map(
			"If-Modified-Since" -> """Sat, 21 Dec 2013 10:45:08 GMT""",
			"If-None-Match" -> """"3f5a53c536f7c1c364c9475f2b5f4033b75d68c0""""
	)

	val headers_31 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"0a8fde8f8fc4f1295f42670a7cfd125c00769df0""""
	)

	val headers_32 = Map(
			"If-Modified-Since" -> """Mon, 28 Apr 2014 13:47:54 GMT""",
			"If-None-Match" -> """"46b865a9914d406a987fdbbeb1a9d7a8c3bdbfca""""
	)

	val headers_33 = Map(
			"If-Modified-Since" -> """Mon, 28 Apr 2014 13:47:54 GMT""",
			"If-None-Match" -> """"b09da4c7f4ed9663fa90e5f42b300f8ca8303c9f""""
	)

	val headers_34 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"20d8f242bd463d81713ff7298ffaf161e4d65773""""
	)

	val headers_35 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"71a87dc9d26d4cff7083df709493d0567cbabe77""""
	)

	val headers_36 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"4ab72d1c834bd3aea1fc6936513e03187971da19""""
	)

	val headers_37 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"76814329dcc5cff9b9bb69d61fd69f566a6a69d3""""
	)

	val headers_38 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"f14daa7cfdd2d07db89dcd5003f02e957d379ca8""""
	)

	val headers_39 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"ea84819bf60d75ea2a1384575ac4e5e343203c22""""
	)

	val headers_40 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"733e9b08926d72efdb2e0e0f608e5134b764abc1""""
	)

	val headers_41 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"9885f1b91be26e7114329e02fb35b6d9bb7690f7""""
	)

	val headers_42 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"7fd8039b7f46f4499fc08020f986e164993a7789""""
	)

	val headers_43 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"45b41a5401872f7d389ebea560168294503e2aa3""""
	)

	val headers_44 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"e0ed96c409a217932e243ca5c25990ebe5daf8ba""""
	)

	val headers_45 = Map(
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:14 GMT""",
			"If-None-Match" -> """"077e390959a24c7225aaafe2ece10fbb89a8ec10""""
	)

	val headers_46 = Map(
			"Accept" -> """application/json, text/plain, */*""",
			"If-Modified-Since" -> """Fri, 25 Apr 2014 19:49:04 GMT""",
			"If-None-Match" -> """"b72a21e264c1f88b2660a032771b239542866d1d""""
	)

	val headers_47 = Map(
			"Accept" -> """image/png,image/*;q=0.8,*/*;q=0.5"""
	)

	val headers_48 = Map(
			"Accept" -> """application/json, text/plain, */*"""
	)

	val headers_54 = Map(
			"Accept" -> """application/json, text/plain, */*""",
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:16 GMT""",
			"If-None-Match" -> """"27c21ec0f40c72b9ffebe7d13939c7b217972503""""
	)

	val headers_56 = Map(
			"Accept" -> """application/json, text/plain, */*""",
			"If-Modified-Since" -> """Mon, 28 Apr 2014 13:47:54 GMT""",
			"If-None-Match" -> """"65fcd5392f9146304a649e0a887c5e2e9076c014""""
	)

	val headers_59 = Map(
			"Accept" -> """application/json, text/plain, */*""",
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:16 GMT""",
			"If-None-Match" -> """"162418ef968938fa543b8986a26119a6b6621b25""""
	)

	val headers_60 = Map(
			"Accept" -> """application/json, text/plain, */*""",
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:16 GMT""",
			"If-None-Match" -> """"b142d0429c2a26dc1172f0f056a4c66b726d7ae4""""
	)

	val headers_61 = Map(
			"Accept" -> """application/json, text/plain, */*""",
			"If-Modified-Since" -> """Wed, 30 Apr 2014 20:42:46 GMT""",
			"If-None-Match" -> """"db59947b4bbf9f4f24709e67e9d4f0ffe519446a""""
	)

	val headers_65 = Map(
			"Accept" -> """application/json, text/plain, */*""",
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:16 GMT""",
			"If-None-Match" -> """"42e8cbfcc4b92d387569a76bf2fbedf8a9882a88""""
	)

	val headers_66 = Map(
			"Accept" -> """application/json, text/plain, */*""",
			"If-Modified-Since" -> """Fri, 31 Jan 2014 00:28:16 GMT""",
			"If-None-Match" -> """"b6e257c296b9b310459ab12dd5ffca5b6ae68c20""""
	)


	val chain_0 =
		exec(http("GET /")
					.get("/")
					.headers(headers_1)
			)
		.pause(5)
		.exec(http("GET /assets/app/stylesheets/app.css")
					.get("/assets/app/stylesheets/app.css")
					.headers(headers_2)
			)
		.pause(171 milliseconds)
		.exec(http("GET http://maps.googleapis.com/maps/api/js")
					.get("http://maps.googleapis.com/maps/api/js")
					.queryParam("""sensor""", """false""")
			)
		.pause(753 milliseconds)
		.exec(http("GET /assets/app/lib/glyphicons/fonts/glyphicons-halflings-regular.woff")
					.get("/assets/app/lib/glyphicons/fonts/glyphicons-halflings-regular.woff")
					.headers(headers_1)
			)
		.pause(212 milliseconds)
		.exec(http("GET /assets/app/lib/requirejs/require.js")
					.get("/assets/app/lib/requirejs/require.js")
			)
		.pause(1)
		.exec(http("GET /assets/app/js/main.js")
					.get("/assets/app/js/main.js")
					.headers(headers_6)
					.check(status.is(304))
			)
		.pause(614 milliseconds)
		.exec(http("GET /assets/app/js/bootstrap.js")
					.get("/assets/app/js/bootstrap.js")
					.headers(headers_7)
					.check(status.is(304))
			)
		.pause(929 milliseconds)
		.exec(http("GET /assets/app/js/routes.js")
					.get("/assets/app/js/routes.js")
					.headers(headers_8)
					.check(status.is(304))
			)
		.pause(197 milliseconds)
		.exec(http("GET /assets/app/js/app.js")
					.get("/assets/app/js/app.js")
					.headers(headers_9)
					.check(status.is(304))
			)
		.pause(220 milliseconds)
		.exec(http("GET /assets/app/lib/angular/angular.min.js")
					.get("/assets/app/lib/angular/angular.min.js")
			)
		.pause(497 milliseconds)
		.exec(http("GET /assets/app/js/controllers/index.js")
					.get("/assets/app/js/controllers/index.js")
					.headers(headers_11)
					.check(status.is(304))
			)
		.pause(23 milliseconds)
		.exec(http("GET /assets/app/lib/highlight/highlight.pack.js")
					.get("/assets/app/lib/highlight/highlight.pack.js")
			)
		.pause(504 milliseconds)
		.exec(http("GET /assets/app/lib/angular/angular-cookies.min.js")
					.get("/assets/app/lib/angular/angular-cookies.min.js")
					.headers(headers_13)
					.check(status.is(304))
			)
		.pause(907 milliseconds)
		.exec(http("GET /assets/app/js/services/index.js")
					.get("/assets/app/js/services/index.js")
					.headers(headers_14)
					.check(status.is(304))
			)
		.exec(http("GET http://maps.googleapis.com/maps/api/js/AuthenticationService.Authenticate")
					.get("http://maps.googleapis.com/maps/api/js/AuthenticationService.Authenticate")
					.queryParam("""token""", """84335""")
					.queryParam("""callback""", """_xdc_._nldkc6""")
					.queryParam("""1shttp://www.yannick-saintmartino.com/""", """""")
					.queryParam("""5e1""", """""")
			)
		.pause(31 milliseconds)
		.exec(http("GET /assets/app/js/controllers/connaissancesCtrl.js")
					.get("/assets/app/js/controllers/connaissancesCtrl.js")
					.headers(headers_16)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/controllers/technosCtrl.js")
					.get("/assets/app/js/controllers/technosCtrl.js")
					.headers(headers_17)
					.check(status.is(304))
			)
		.pause(401 milliseconds)
		.exec(http("GET /assets/app/js/filters/index.js")
					.get("/assets/app/js/filters/index.js")
					.headers(headers_18)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/controllers/indexCtrl.js")
					.get("/assets/app/js/controllers/indexCtrl.js")
					.headers(headers_19)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/controllers/championnatCtrl.js")
					.get("/assets/app/js/controllers/championnatCtrl.js")
					.headers(headers_20)
					.check(status.is(304))
			)
		.pause(36 milliseconds)
		.exec(http("GET /assets/app/lib/angular/angular-resource.min.js")
					.get("/assets/app/lib/angular/angular-resource.min.js")
					.headers(headers_21)
					.check(status.is(304))
			)
		.pause(417 milliseconds)
		.exec(http("GET /assets/app/js/controllers/websocketCtrl.js")
					.get("/assets/app/js/controllers/websocketCtrl.js")
					.headers(headers_22)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/controllers/clubCtrl.js")
					.get("/assets/app/js/controllers/clubCtrl.js")
					.headers(headers_23)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/lib/highlight/angular-highlightjs.min.js")
					.get("/assets/app/lib/highlight/angular-highlightjs.min.js")
					.headers(headers_24)
					.check(status.is(304))
			)
		.pause(15 milliseconds)
		.exec(http("GET /assets/app/js/controllers/planCtrl.js")
					.get("/assets/app/js/controllers/planCtrl.js")
					.headers(headers_25)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/controllers/cssCtrl.js")
					.get("/assets/app/js/controllers/cssCtrl.js")
					.headers(headers_26)
					.check(status.is(304))
			)
		.pause(18 milliseconds)
		.exec(http("GET /assets/app/lib/angular/angular-animate.min.js")
					.get("/assets/app/lib/angular/angular-animate.min.js")
					.headers(headers_27)
					.check(status.is(304))
			)
		.pause(761 milliseconds)
		.exec(http("GET /assets/app/js/services/actualitesService.js")
					.get("/assets/app/js/services/actualitesService.js")
					.headers(headers_28)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/controllers/parcoursCtrl.js")
					.get("/assets/app/js/controllers/parcoursCtrl.js")
					.headers(headers_29)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/lib/angular/angular-route.min.js")
					.get("/assets/app/lib/angular/angular-route.min.js")
					.headers(headers_30)
					.check(status.is(304))
			)
		.pause(23 milliseconds)
		.exec(http("GET /assets/app/js/controllers/authenticateCtrl.js")
					.get("/assets/app/js/controllers/authenticateCtrl.js")
					.headers(headers_31)
					.check(status.is(304))
			)
		.pause(142 milliseconds)
		.exec(http("GET /assets/app/js/services/formationsService.js")
					.get("/assets/app/js/services/formationsService.js")
					.headers(headers_32)
					.check(status.is(304))
			)
		.pause(58 milliseconds)
		.exec(http("GET /assets/app/js/services/emploisService.js")
					.get("/assets/app/js/services/emploisService.js")
					.headers(headers_33)
					.check(status.is(304))
			)
		.pause(1)
		.exec(http("GET /assets/app/js/services/authService.js")
					.get("/assets/app/js/services/authService.js")
					.headers(headers_34)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/services/websocketService.js")
					.get("/assets/app/js/services/websocketService.js")
					.headers(headers_35)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/services/informationsService.js")
					.get("/assets/app/js/services/informationsService.js")
					.headers(headers_36)
					.check(status.is(304))
			)
		.pause(198 milliseconds)
		.exec(http("GET /assets/app/js/services/championnatService.js")
					.get("/assets/app/js/services/championnatService.js")
					.headers(headers_37)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/filters/truncateText.js")
					.get("/assets/app/js/filters/truncateText.js")
					.headers(headers_38)
					.check(status.is(304))
			)
		.pause(29 milliseconds)
		.exec(http("GET /assets/app/js/services/connaissancesService.js")
					.get("/assets/app/js/services/connaissancesService.js")
					.headers(headers_39)
					.check(status.is(304))
			)
		.pause(80 milliseconds)
		.exec(http("GET /assets/app/js/services/clubService.js")
					.get("/assets/app/js/services/clubService.js")
					.headers(headers_40)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/controllers/module.js")
					.get("/assets/app/js/controllers/module.js")
					.headers(headers_41)
					.check(status.is(304))
			)
		.pause(103 milliseconds)
		.exec(http("GET /assets/app/js/services/infosGeneralesService.js")
					.get("/assets/app/js/services/infosGeneralesService.js")
					.headers(headers_42)
					.check(status.is(304))
			)
		.exec(http("GET /assets/app/js/services/module.js")
					.get("/assets/app/js/services/module.js")
					.headers(headers_43)
					.check(status.is(304))
			)
		.pause(247 milliseconds)
		.exec(http("GET /assets/app/js/filters/module.js")
					.get("/assets/app/js/filters/module.js")
					.headers(headers_44)
					.check(status.is(304))
			)
		.pause(500 milliseconds)
		.exec(http("GET /assets/app/lib/requirejs-domready/domReady.js")
					.get("/assets/app/lib/requirejs-domready/domReady.js")
					.headers(headers_45)
					.check(status.is(304))
			)
		.pause(689 milliseconds)
		.exec(http("GET /assets/app/partials/index.html")
					.get("/assets/app/partials/index.html")
					.headers(headers_46)
					.check(status.is(304))
			)
		.pause(4)
		.exec(http("GET /assets/app/images/presentation/diapo_1.png")
					.get("/assets/app/images/presentation/diapo_1.png")
					.headers(headers_47)
			)
		.pause(3)
		.exec(http("GET /infosGenerales")
					.get("/infosGenerales")
					.headers(headers_48)
			)
		.pause(205 milliseconds)
		.exec(http("GET /actualites")
					.get("/actualites")
					.headers(headers_48)
			)
		.pause(3)
		.exec(http("GET /assets/app/images/presentation/diapo_2.png")
					.get("/assets/app/images/presentation/diapo_2.png")
					.headers(headers_47)
			)
		.pause(8)
		.exec(http("GET /assets/app/images/presentation/diapo_3.png")
					.get("/assets/app/images/presentation/diapo_3.png")
					.headers(headers_47)
			)
		.pause(5)
		.exec(http("GET /assets/app/images/presentation/diapo_4.png")
					.get("/assets/app/images/presentation/diapo_4.png")
					.headers(headers_47)
			)
		.pause(7)
		.exec(http("GET /assets/app/images/presentation/diapo_5.png")
					.get("/assets/app/images/presentation/diapo_5.png")
					.headers(headers_47)
			)
		.pause(6)
		.exec(http("GET /assets/app/partials/connaissances.html")
					.get("/assets/app/partials/connaissances.html")
					.headers(headers_54)
					.check(status.is(304))
			)
		.pause(1)
		.exec(http("GET /connaissances")
					.get("/connaissances")
					.headers(headers_48)
			)
		.pause(7)
		.exec(http("GET /assets/app/partials/parcours.html")
					.get("/assets/app/partials/parcours.html")
					.headers(headers_56)
					.check(status.is(304))
			)
		.pause(1)
		.exec(http("GET /formations")
					.get("/formations")
					.headers(headers_48)
			)
		.pause(1)
	val chain_1 =
		exec(http("GET /emplois")
					.get("/emplois")
					.headers(headers_48)
			)
		.pause(6)
		.exec(http("GET /assets/app/partials/technos.html")
					.get("/assets/app/partials/technos.html")
					.headers(headers_59)
					.check(status.is(304))
			)
		.pause(545 milliseconds)
		.exec(http("GET /assets/app/partials/technos/main.html")
					.get("/assets/app/partials/technos/main.html")
					.headers(headers_60)
					.check(status.is(304))
			)
		.pause(4)
		.exec(http("GET /assets/app/partials/technos/site.html")
					.get("/assets/app/partials/technos/site.html")
					.headers(headers_61)
					.check(status.is(304))
			)
		.pause(1)
		.exec(http("GET /assets/app/images/technos/frontend.jpg")
					.get("/assets/app/images/technos/frontend.jpg")
					.headers(headers_47)
			)
		.exec(http("GET /assets/app/images/technos/front_back.jpg")
					.get("/assets/app/images/technos/front_back.jpg")
					.headers(headers_47)
			)
		.exec(http("GET /assets/app/images/technos/backend.jpg")
					.get("/assets/app/images/technos/backend.jpg")
					.headers(headers_47)
			)
		.pause(8)
		.exec(http("GET /assets/app/partials/technos/websocket.html")
					.get("/assets/app/partials/technos/websocket.html")
					.headers(headers_65)
					.check(status.is(304))
			)
		.pause(5)
		.exec(http("GET /assets/app/partials/technos/bdd.html")
					.get("/assets/app/partials/technos/bdd.html")
					.headers(headers_66)
					.check(status.is(304))
			)
		.pause(922 milliseconds)
		.exec(http("GET /qrCode")
					.get("/qrCode")
					.headers(headers_47)
					.queryParam("""idWebsocketSession""", """""")
			)
		.pause(2)
		.exec(http("GET /assets/app/partials/technos/database/championnatList.html")
					.get("/assets/app/partials/technos/database/championnatList.html")
					.headers(headers_48)
			)
		.pause(521 milliseconds)
		.exec(http("GET /assets/app/partials/authenticate.html")
					.get("/assets/app/partials/authenticate.html")
					.headers(headers_48)
			)
		.pause(1)
		.exec(http("GET /getConnexion")
					.get("/getConnexion")
					.headers(headers_48)
					.check(status.is(401))
			)
		.pause(13)
		.exec(http("GET /connexion")
					.get("/connexion")
					.headers(headers_48)
					.queryParam("""username""", """ouistiti""")
					.queryParam("""password""", """ouistiti""")
			)
		.pause(3)
		.exec(http("GET /championnats")
					.get("/championnats")
					.headers(headers_48)
					.queryParam("""s""", """nom""")
					.queryParam("""filtreNom""", """""")
					.queryParam("""p""", """0""")
					.queryParam("""o""", """asc""")
					.queryParam("""filtrePays""", """""")
			)
		.pause(1)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """142""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """35""")
			)
		.pause(327 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """36""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """32""")
			)
		.pause(223 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """137""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """34""")
			)
		.pause(98 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """135""")
			)
		.pause(227 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """37""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """136""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """138""")
			)
		.pause(6)
		.exec(http("GET /assets/app/partials/technos/database/clubList.html")
					.get("/assets/app/partials/technos/database/clubList.html")
					.headers(headers_48)
			)
		.pause(1)
		.exec(http("GET /getConnexion")
					.get("/getConnexion")
					.headers(headers_48)
			)
		.pause(691 milliseconds)
		.exec(http("GET /club")
					.get("/club")
					.headers(headers_48)
					.queryParam("""s""", """nom""")
					.queryParam("""filtreNom""", """""")
					.queryParam("""p""", """0""")
					.queryParam("""o""", """asc""")
					.queryParam("""championnat""", """5""")
			)
		.pause(1)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """101""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """87""")
			)
		.pause(205 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """78""")
			)
		.pause(103 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """94""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """89""")
			)
		.pause(169 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """129""")
			)
		.pause(138 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """55""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """114""")
			)
		.pause(74 milliseconds)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """86""")
			)
		.exec(http("GET /getImage")
					.get("/getImage")
					.headers(headers_47)
					.queryParam("""c""", """151""")
			)
		.pause(1)
		.exec(http("GET /getImage")
					.get("/club")
					.headers(headers_48)
					.queryParam("""s""", """nom""")
					.queryParam("""filtreNom""", """""")
					.queryParam("""p""", """0""")
					.queryParam("""o""", """asc""")
					.queryParam("""championnat""", """5""")
			)
		.pause(9)
		.exec(http("GET /getImage")
					.get("/assets/app/partials/planDuSite.html")
					.headers(headers_48)
			)

	val scn = scenario("Scenario Name")
		.exec(
			chain_0,			chain_1		)

	setUp(scn.users(10).protocolConfig(httpConf))
}