package peaksoft;

import peaksoft.config.ConfigurationHibernate;
import peaksoft.entity.Address;
import peaksoft.entity.Country;
import peaksoft.entity.Programmer;
import peaksoft.entity.Project;
import peaksoft.enums.Countryy;
import peaksoft.enums.Status;
import peaksoft.service.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ConfigurationHibernate.getManagerFactory();
        AddressService addressService = new AdressServiceImpl();
        CountryService countryService = new CountryServiceImpl();
        ProgrammerService programmerService = new ProgrammerServiceImpl();
        ProjectService projectService = new ProjectServiceImpl();
        Programmer programmer = new Programmer("Nurik Djoldoshov", "n@gmail.com", new Date(2004, 4, 23), Status.COLLABORATOR);
        Programmer programmer2 = new Programmer("Alibek Altynbek uulu", "a@gmail.com", new Date(2002, 9, 12), Status.OWNER);
        List<Programmer> programmers = new ArrayList<>(List.of
                (new Programmer("Dastan Akbaraliev", "d@gmail.com", new Date(2003, 9, 4), Status.COLLABORATOR),
                        new Programmer("Ilim Shabdanov", "i@gmail.com", new Date(2003, 10, 3), Status.COLLABORATOR),
                        new Programmer("Ishak Abduhamitov", "i@gmail.com", new Date(2002, 05, 15), Status.OWNER)));


        Address address = new Address("Bishkek", 245, Countryy.KYRGYZSTAN);
        Address address2 = new Address("New-York", 13, Countryy.USA);
        List<Address> addressList = new ArrayList<>(List.of(new Address("Shanghai", 78, Countryy.CHINA),
                new Address("Almaty", 245, Countryy.KAZAKHSTAN),
                new Address("Moscow", 245, Countryy.RUSSIAN)));


        Country country = new Country(Countryy.KYRGYZSTAN, "312 very beautiful");
        Country country2 = new Country(Countryy.USA, "the country where you want to live");
        List<Country> countries =
                new ArrayList<>(List.of(new Country(Countryy.CHINA, "Great Wall"),
                        (new Country(Countryy.KAZAKHSTAN, "a country where you want to walk all day")),
                        (new Country(Countryy.RUSSIAN, "no no no !!!!! "))));

        Project project = new Project("C a r s", "C A R S ", new Date(2023, 2, 8), new Date(2023, 5, 10), new BigDecimal(21000));
        Project project2 = new Project("Tik Tok", "Video ", new Date(2020, 5, 25), new Date(2020, 10, 5), new BigDecimal(50000));
        List<Project> projectList =
                new ArrayList<>(List.of(new Project("Apple", "A P P L E", new Date(2021, 5, 14), new Date(2021, 12, 20), new BigDecimal(130000)),
                        new Project("Cs:Go ", "Strikes", new Date(2010, 1, 5), new Date(2015, 5, 6), new BigDecimal(5000000))));

        while (true) {
            System.out.println("\n1.====== COUNTRY METHODS ======" +
                    "\n2.====== ADDRESS COUNTRY ======" +
                    "\n3.====== PROGRAMMER METHODS ======" +
                    "\n4.====== PROJECT METHODS ======");
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> {
                    boolean isTrue = true;
                    while (isTrue) {
                        System.out.println("\n======COUNTRY METHODS=====" +
                                "\n1.SAVE COUNTRY :" +
                                "\n2.SAVE ALL COUNTRY :" +
                                "\n3.FIND ALL COUNTRY :" +
                                "\n4.FIND COUNTRY BY ID :" +
                                "\n5.DELETE COUNTRY BY ID :" +
                                "\n6.DELETE ALL COUNTRY :" +
                                "\n7.UPDATE COUNTRY :" +
                                "\n8.FIND LONG DESCRIPTION :" +
                                "\n9.GET COUNT THE COUNTRY :" +
                                "\n0.EXIT() :");
                        System.out.println("ENTER BY COMMAND :");
                        int a = new Scanner(System.in).nextInt();
                        switch (a) {
                            case 1 -> countryService.saveCountry(country);
                            case 2 -> System.out.println(countryService.saveAllCountry(countries));
                            case 3 -> System.out.println(countryService.findAll());
                            case 4 -> {
                                System.out.println("Enter by country id :");
                                Long countryId = new Scanner(System.in).nextLong();
                                System.out.println(countryService.findById(countryId));
                            }
                            case 5 -> {
                                System.out.println("Enter by country id :");
                                Long countryId = new Scanner(System.in).nextLong();
                                System.out.println(countryService.deletedById(countryId));
                            }
                            case 6 -> countryService.deletedAll();
                            case 7 -> {
                                System.out.println("Enter by country id :");
                                Long countryId = new Scanner(System.in).nextLong();
                                System.out.println(countryService.updated(country2, countryId));
                            }
                            case 8 -> System.out.println(countryService.longByDescription());
                            case 9 -> {
                                System.out.println("Enter by country :");
                                java.lang.String countryName = new Scanner(System.in).nextLine();
                                System.out.println(countryService.getSameCountryProgrammer(countryName));
                            }
                            case 0 -> isTrue = false;
                        }
                    }

                }
                case 2 -> {
                    boolean isTrue = true;
                    while (isTrue) {
                        System.out.println("\n======ADDRESS METHODS=====" +
                                "\n1.SAVE ADDRESS :" +
                                "\n2.SAVE ALL ADDRESS :" +
                                "\n3.FIND ADDRESS BY ID :" +
                                "\n4.DELETE ADDRESS BY ID :" +
                                "\n5.DELETE ALL ADDRESS :" +
                                "\n6.UPDATE ADDRESS :" +
                                "\n0.EXIT() :");
                        System.out.println("ENTER BY COMMAND :");
                        int a = new Scanner(System.in).nextInt();
                        switch (a) {
                            case 1 -> addressService.saveAddress(address);
                            case 2 -> System.out.println(addressService.saveAllAddress(addressList));
                            case 3 -> {
                                System.out.println("Enter by address id :");
                                Long addressId = new Scanner(System.in).nextLong();
                                System.out.println(addressService.findById(addressId));
                            }
                            case 4 -> {
                                System.out.println("Enter by address id :");
                                Long addressId = new Scanner(System.in).nextLong();
                                System.out.println(addressService.deletedById(addressId));
                            }
                            case 5 -> addressService.deletedAll();
                            case 6 -> {
                                System.out.println("Enter by address id :");
                                Long addressId = new Scanner(System.in).nextLong();
                                System.out.println(addressService.updated(address2, addressId));
                            }
                            case 0 -> isTrue = false;
                        }
                    }
                }
                case 3 -> {
                    boolean isTrue = true;
                    while (isTrue) {
                        System.out.println("\n======PROGRAMMER METHODS=====" +
                                "\n1.SAVE PROGRAMMER :" +
                                "\n2.SAVE ALL PROGRAMMERS :" +
                                "\n3.FIND PROGRAMMER BY ID :" +
                                "\n4.DELETE PROGRAMMER BY ID :" +
                                "\n5.DELETE ALL PROGRAMMER :" +
                                "\n6.UPDATE PROGRAMMER :" +
                                "\n7.GET PROGRAMMER BY COUNTRY ID :" +
                                "\n8.GET YOUNGER PROGRAMMER :" +
                                "\n9.GET OLDER PROGRAMMER :" +
                                "\n0.EXIT() :");
                        System.out.println("ENTER BY COMMAND :");
                        int a = new Scanner(System.in).nextInt();
                        switch (a) {
                            case 1 -> programmerService.saveProgrammer(programmer);
                            case 2 -> System.out.println(programmerService.saveAll(programmers));
                            case 3 -> {
                                System.out.println("Enter by programmer id :");
                                Long programmerId = new Scanner(System.in).nextLong();
                                System.out.println(programmerService.findById(programmerId));
                            }
                            case 4 -> {
                                System.out.println("Enter by programmer id :");
                                Long programmerId = new Scanner(System.in).nextLong();
                                System.out.println(programmerService.deletedById(programmerId));
                            }
                            case 5 -> programmerService.deletedAll();
                            case 6 -> {
                                System.out.println("Enter by programmer id :");
                                Long programmerId = new Scanner(System.in).nextLong();
                                System.out.println(programmerService.updated(programmer2, programmerId));
                            }
                            case 7 -> {
                                System.out.println("Enter by country id :");
                                Long countryId = new Scanner(System.in).nextLong();
                                System.out.println(programmerService.countFrom(countryId));
                            }
                            case 9 -> System.out.println(programmerService.getYoungProgrammer());
                            case 10 -> System.out.println(programmerService.getOldProgrammer());
                            case 0 -> isTrue = false;

                        }

                    }
                }
                case 4 -> {
                    boolean isTrue = true;
                    while (isTrue) {
                        System.out.println("\n======PROJECT METHODS=====" +
                                "\n1.SAVE PROJECT :" +
                                "\n2.SAVE ALL PROJECTS :" +
                                "\n3.GET ALL PROJECTS :" +
                                "\n4.FIND PROJECT BY ID :" +
                                "\n5.DELETE PROJECT BY ID :" +
                                "\n6.DELETE ALL PROJECTS :" +
                                "\n7.UPDATE PROJECT :" +
                                "\n8.ASSIGN PROJECT TO PROGRAMMER :" +
                                "\n9.FIND EXPENSIVE PROJECT :" +
                                "\n10.FIND SHORTER TIME WRITER PROJECT :" +
                                "\n0.EXIT() :");
                        System.out.println("ENTER BY COMMAND :");
                        int a = new Scanner(System.in).nextInt();
                        switch (a) {
                            case 1 -> projectService.saveProject(project);
                            case 2 -> System.out.println(projectService.saveAll(projectList));
                            case 3 -> System.out.println(projectService.findAll());
                            case 4 -> {
                                System.out.println("Enter by project id :");
                                Long projectId = new Scanner(System.in).nextLong();
                                System.out.println(addressService.findById(projectId));
                            }
                            case 5 -> {
                                System.out.println("Enter by project id :");
                                Long projectId = new Scanner(System.in).nextLong();
                                System.out.println(addressService.deletedById(projectId));
                            }
                            case 6 -> addressService.deletedAll();
                            case 7 -> {
                                System.out.println("Enter by project id :");
                                Long projectId = new Scanner(System.in).nextLong();
                                System.out.println(projectService.updated(project2, projectId));
                            }
                            case 0 -> isTrue = false;
                        }
                    }
                }
            }


        }
    }
}
