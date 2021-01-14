package org.dhbw.mosbach.ai.keepyourday;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dhbw.mosbach.ai.keepyourday.objects.DayInfo;
import org.dhbw.mosbach.ai.keepyourday.objects.NewsInfo;
import org.dhbw.mosbach.ai.keepyourday.objects.PostDayInfo;
import org.dhbw.mosbach.ai.keepyourday.objects.WeatherInfo;
import org.dhbw.mosbach.ai.keepyourday.util.APIManager;

@Path("/keepyourday")
public class KeepYourDay {

	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersion() {
		// Ausgabe Version 1.0
		return "1.0";
	}

	@GET
	@Path("/getdayinfolist/{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<DayInfo> getDayInfoList(@PathParam("user") String user) {
		// Ermittlung der letzten 3 Tage und formatieren
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();

		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();

		cal.add(Calendar.DATE, -1);
		Date twoDaysAgo = cal.getTime();

		String formattedDate = sdf.format(date);
		String formattedDateYesterday = sdf.format(yesterday);
		String formattedDateTwoDaysAgo = sdf.format(twoDaysAgo);

		// Daten in Liste einfügen und senden
		ArrayList<DayInfo> dayInfoList = new ArrayList<DayInfo>();
		dayInfoList.add(APIManager.instance.getDayInfoFromDate(user, formattedDate));
		dayInfoList.add(APIManager.instance.getDayInfoFromDate(user, formattedDateYesterday));
		dayInfoList.add(APIManager.instance.getDayInfoFromDate(user, formattedDateTwoDaysAgo));

		return dayInfoList;
	}

	@GET
	@Path("/getdayinfo/{user}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public DayInfo getDayInfo(@PathParam("user") String user, @PathParam("date") String date) {
		// Rufe DayInfo ab

		return APIManager.instance.getDayInfoFromDate(user, date);
	}

	@POST
	@Path("/postdayinfo/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String postDayInfo(PostDayInfo postDayInfo) {
		// DayInfo Objekt posten, dabei Wetter und News abfragen

		boolean success = APIManager.instance.addDayInfo(postDayInfo);

		APIManager.instance.getNewsInfoListFromDate(postDayInfo.getDate());
		APIManager.instance.getWeatherInfoFromDate(postDayInfo.getDate());

		if (success) {
			return "Sucessfully POST DayInfo!";
		} else {
			return "Failed POST DayInfo! DayInfo already exists. Try PUT method!";
		}
	}

	@PUT
	@Path("/putdayinfo/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String putDayInfo(PostDayInfo postDayInfo) {
		// DayInfo Ojekt updaten, falls vorhanden

		boolean success = APIManager.instance.putDayInfo(postDayInfo);

		if (success) {
			return "Sucessfully PUT DayInfo! DayInfo updated!";
		} else {
			return "Failed PUT DayInfo! DayInfo doesn't exist. Try POST method!";
		}

	}

	@DELETE
	@Path("/deletedayinfo/{user}/{date}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDayInfo(@PathParam("user") String user, @PathParam("date") String date) {
		// DayInfo Objekt löschen, falls enthalten

		boolean success = APIManager.instance.deleteDayInfoFromDate(user, date);

		if (success) {
			return "Sucessfully DELETE DayInfo!";
		} else {
			return "Failed DELETE DayInfo! DayInfo doesn't exist for user=" + user + " and date=" + date;
		}
	}

	@GET
	@Path("/news")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<NewsInfo> getNews() {
		// Hole news vom heutigen Tag
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(new Date());

		return APIManager.instance.getNewsInfoListFromDate(formattedDate);
	}

	@GET
	@Path("/weather")
	@Produces(MediaType.APPLICATION_JSON)
	public WeatherInfo getWeather() {
		// Hile weather vom heutigen Tag
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(new Date());

		return APIManager.instance.getWeatherInfoFromDate(formattedDate);
	}
}
