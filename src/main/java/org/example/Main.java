package org.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

  /**
   * if文を使って、苗字と名前が2文字以上なのかを判定する。
   * <p>
   * firstName →苗字
   * <p>
   * lastName　→名前
   *
   * @param args
   */
  public static void main(String[] args) {

    String firstName = "武田";
    String lastName = "信玄";

    boolean isNameValid = firstName.length() >= 2 && lastName.length() >= 2;

    if (isNameValid) {
      System.out.println(firstName + lastName);
    } else {
      System.out.println("条件に一致しませんでした。");
    }

    LocalDateTimeChecker localDateTimeChecker = new LocalDateTimeChecker();
    localDateTimeChecker.checkDate();

    ZonedDateTimeChecker zonedChecker = new ZonedDateTimeChecker();
    zonedChecker.checkDate();
  }
}

/**
 * LocalDateTimeで日本標準時間の日付を指定した日付判定
 * <p>
 * month　→月
 * <p>
 * day　→日
 */
class LocalDateTimeChecker {

  public void checkDate() {
    // 今日の日付を取得
    LocalDateTime toDay = LocalDateTime.now();

    int month = toDay.getMonthValue();
    int day = toDay.getDayOfMonth();

    // 条件判定
    if (month == 12 && day == 31) {
      System.out.println("締め日です。");
    } else if (month == 1 && day == 1) {
      System.out.println("間に合いませんでした。");
    } else {
      System.out.println("間に合います");
    }
  }
}

/**
 * ZonedDateTimeでアメリカのニューヨークを指定した日付判定(サマータイムが含まれる)
 */
class ZonedDateTimeChecker {

  public void checkDate() {
    // 今日の日付を取得
    ZonedDateTime toDay = ZonedDateTime.now(ZoneId.of("America/New_York"));

    int month = toDay.getMonthValue();

    int day = toDay.getDayOfMonth();

    if (month == 12 && day == 31) {
      System.out.println("締め日です。");
    } else if (month == 1 && day == 1) {
      System.out.println("間に合いませんでした。");
    } else {
      System.out.println("間に合います");
    }

  }
}



