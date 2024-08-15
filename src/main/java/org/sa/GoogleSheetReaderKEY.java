package org.sa;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class GoogleSheetReaderKEY {
  private static final String APPLICATION_NAME = "sheets-reader";
  private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
  private static final String SPREADSHEET_ID_DAILY = "1E55MZpCV1f6A-p8vhw_xwXab4bnyAGovVQhWePoi1tg";
  private static final String RANGE = "daily20241!A:F";
  private static final String API_KEY = System.getenv("google_api");

  public static void main(String[] args) throws IOException, GeneralSecurityException {
    Sheets sheetsService = getSheetsService();
    ValueRange response = sheetsService.spreadsheets().values()
        .get(SPREADSHEET_ID_DAILY, RANGE)
        .setKey(API_KEY)
        .execute();

    List<List<Object>> values = response.getValues();

    if (values == null || values.isEmpty()) {
      System.out.println("No data found.");
    } else {
      values.forEach(row -> {
        String rowData = row.stream()
            .map(Object::toString)
            .reduce((a, b) -> a + "\t" + b)
            .orElse("");
        System.out.println(rowData);
      });
    }
  }

  private static Sheets getSheetsService() throws GeneralSecurityException, IOException {
    return new Sheets.Builder(new NetHttpTransport(), JSON_FACTORY, null)
        .setApplicationName(APPLICATION_NAME)
        .build();
  }
}
