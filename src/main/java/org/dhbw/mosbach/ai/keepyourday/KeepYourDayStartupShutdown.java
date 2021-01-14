package org.dhbw.mosbach.ai.keepyourday;

import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.dhbw.mosbach.ai.keepyourday.util.HSQLDBWrapper;
import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class KeepYourDayStartupShutdown {

	private static final Logger LOGGER = Logger.getLogger("ListenerBean");

	void onStart(@Observes StartupEvent ev) throws SQLException {
		// Beim starten des Service DB verbinden, Tabellen falls nicht existent
		// erstellen und DB wieder schließen.
		LOGGER.info("The application is starting...");
		HSQLDBWrapper.getInstance().connect();
		HSQLDBWrapper.getInstance().update(
				"CREATE TABLE IF NOT EXISTS PUBLIC.WEATHERINFOS (date LONGVARCHAR NOT NULL, maxTemp DOUBLE NOT NULL, minTemp DOUBLE NOT NULL);");
		HSQLDBWrapper.getInstance().update(
				"CREATE TABLE IF NOT EXISTS PUBLIC.NEWSINFOS (date LONGVARCHAR NOT NULL, title LONGVARCHAR NOT NULL, url LONGVARCHAR NOT NULL);");
		HSQLDBWrapper.getInstance().update(
				"CREATE TABLE IF NOT EXISTS PUBLIC.DAYINFOS (name LONGVARCHAR NOT NULL, date LONGVARCHAR NOT NULL, happiness INTEGER NOT NULL);");
		HSQLDBWrapper.getInstance().close();
	}

	void onStop(@Observes ShutdownEvent ev) {
		LOGGER.info("The application is stopping...");
	}
}
