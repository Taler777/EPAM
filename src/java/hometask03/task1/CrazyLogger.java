package hometask03.task1;
/*
Задание 1. Строковые классы

Необходимо создать класс CrazyLogger, ведущий журнал лога, используя как накопитель объект типа StringBuilder.
Логгер должен содержать методы поиска определенной информации в таком логе
[с возможностью вывода ее в поток ввода вывода].
Информацию логгер хранит в форматированном виде: dd-mm-YYYY : hh-mm – message

 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger {

    private static StringBuilder crazyLog = new StringBuilder();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm - ");
    private static final String END_OF_MESSAGE = ";\n";
    private static final int PATTERN_LENGTH = 24;

    static void log(String message) {
        crazyLog.append(LocalDateTime.now().format(formatter));
        crazyLog.append(message);
        crazyLog.append(END_OF_MESSAGE);
    }

    static String search(String searchText) {
        StringBuilder sb = new StringBuilder();
        int index = crazyLog.indexOf(searchText);
        while (index != -1) {
            int possibleStart = crazyLog.lastIndexOf(END_OF_MESSAGE, index);
            int start = possibleStart != -1 ? possibleStart + END_OF_MESSAGE.length() : 0;
            int end = crazyLog.indexOf(END_OF_MESSAGE, index) + END_OF_MESSAGE.length();
            sb.append(crazyLog.subSequence(start, end).toString());
            index = crazyLog.indexOf(searchText, index + 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CrazyLogger.log("Once upon a time...");
        CrazyLogger.log("Elvis has left the building");
        CrazyLogger.log("I'll be back");
        CrazyLogger.log("Tomorrow never comes");
        CrazyLogger.log("Peace of cake");
        System.out.println(crazyLog.toString());
        System.out.println(CrazyLogger.search("Elvis"));
    }
}
