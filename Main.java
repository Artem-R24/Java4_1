package com.company;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

    public class Main {
        public static void main(String[] args) throws IOException, CsvValidationException {

            List<Human> list = createList("C:\\foreign_names.csv", ";"); //передаем путь до файла и разделитель
            //осуществляем вывод списка в консоль
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getID() + " " + list.get(i).getName() + " " + list.get(i).getGender() + " " +
                        list.get(i).getBirtDate() + " " + list.get(i).getDivision().get_Title() + " " +
                        list.get(i).getDivision().get_ID() + " " + list.get(i).getSalary());
            }
        }

        public static List createList(String path_to_csv, String separator) throws IOException, CsvValidationException {

            List<Human> list = new ArrayList<Human>();
            List<Division> listCheck = new ArrayList<Division>();
            FileReader fr = new FileReader(path_to_csv);
            CSVParser parser = new CSVParserBuilder()//используем билдер, чтобы изменить разделитесь с , на ;
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .build();
            CSVReader cr = new CSVReaderBuilder(fr)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();
            if (cr == null) {
                throw new FileNotFoundException(path_to_csv);
            } else {
                String[] nextLine;
                nextLine = cr.readNext();
                int iteration = 0;
                while ((nextLine = cr.readNext()) != null) {
                    Human human = new Human(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[2], LocalDate.parse(nextLine[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")), Integer.parseInt(nextLine[5]));
                    boolean containsElement = listCheck.contains(nextLine[4]); //проверяем вхождение (есть ли данное подразделение или же его нет)
                    if (containsElement == true) //если подразделение существует
                    {
                        for (int i=0; i < listCheck.size(); i++) {
                            if (listCheck.get(i).get_Title() == nextLine[4]) iteration = i;
                        }
                        human.setDivision(listCheck.get(listCheck.indexOf(iteration)).get_Title());
                    }
                    else {//если подразделения не существует. Создаем его и записываем в лист
                        Division division = new Division(nextLine[4]);
                        listCheck.add(division);
                        human.setDivision(nextLine[4]);
                    }
                    list.add(human);
                }
            }
            return list;
        }
    }