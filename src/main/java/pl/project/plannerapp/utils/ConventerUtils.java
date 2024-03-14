package pl.project.plannerapp.utils;

import pl.project.plannerapp.DTO.PersonalDataDTO;
import pl.project.plannerapp.model.PersonalData;

public class ConventerUtils {
    public static PersonalData convert(PersonalDataDTO personalDataDTO) {
        return new PersonalDataBuilder()
                .withName(personalDataDTO.getName())
                .withSurname(personalDataDTO.getSurname())
                .withSex(personalDataDTO.getSex())
                .withPhone(personalDataDTO.getPhone())
                .withEmail(personalDataDTO.getEmail())
                .build();
    }

    public static PersonalDataDTO convert(PersonalData personalData) {
        return new PersonalDataDTOBuilder()
                .withName(personalData.getName())
                .withSurname(personalData.getSurname())
                .withSex(personalData.getSex())
                .withPhone(personalData.getPhone())
                .withEmail(personalData.getEmail())
                .build();
    }


    public static LogginData convert(LogginDataDTO logginDataDTO) {
        return new LogginDataBuilder()
                .withLogin(logginDataDTO.getLogin())
                .withPassword(logginDataDTO.getPassword())
                .build();
    }

    public static LogginDataDTO convert(LogginData logginData) {
        return new LogginDataDTOBuilder()
                .withLogin(logginData.getLogin())
                .withPassword(logginData.getPassword())
                .build();
    }

    public static Period convert(PeriodDTO periodDTO) {
        return new PeriodBuilder()
                .withBegin(periodDTO.getBegin())
                .withEnd(periodDTO.getEnd())
                .build();
    }

    public static PeriodDTO convert(Period period) {
        return new PeriodDTOBuilder()
                .withBegin(period.getBegin())
                .withEnd(period.getEnd())
                .build();
    }


    public static PeriodTime convert(PeriodTimeDTO periodTimeDTO) {
        return new PeriodTimeBuilder()
                .withBegin(periodTimeDTO.getBegin())
                .withEnd(periodTimeDTO.getEnd())
                .build();
    }

    public static PeriodTimeDTO convert(PeriodTime periodTime) {
        return new PeriodTimeDTOBuilder()
                .withBegin(periodTime.getBegin())
                .withEnd(periodTime.getEnd())
                .build();
    }

    public static List<User> convertUsers(List<UserDTO> userDTOS) {
        if (userDTOS == null) {
            return new ArrayList<>();
        }
        ArrayList<User> users = new ArrayList<>();
        for (UserDTO dto : userDTOS) {
            users.add(convert(dto));
        }
        return users;
    }

    public static User convert(UserDTO userDTO) {
        return new UserBuilder()
                .withUuid(userDTO.getUuid())
                .withPersonalData(convert(userDTO.getPersonalData()))
                .withDeliveryAddress(convertAddresses(userDTO.getDeliveryAddress()))
                .withLogginData(convert(userDTO.getLogginData()))
                .withOrders(convertOrdersDTO(userDTO.getOrders()))
                .withOperationEvidence(convertOperationEvidenceDTOS(userDTO.getOperationEvidence()))
                .withDiscountCodes(convertDiscountCodeDTOS(userDTO.getDiscountCodes()))
                .withArchive(userDTO.getArchive())
                .build();
    }

    public static User convertNoEvidence(UserDTO userDTO) {
        return new UserBuilder()
                .withUuid(userDTO.getUuid())
                .build();
    }

    public static List<UserDTO> convertUserDTOS(List<User> users) {
        if (users == null) {
            return new ArrayList<>();
        }
        ArrayList<UserDTO> userDTOS = new ArrayList<>();
        for (User dto : users) {
            userDTOS.add(convert(dto));
        }
        return userDTOS;
    }

    public static UserDTO convert(User user) {
        return new UserDTOBuilder()
                .withUuid(user.getUuid())
                .withPersonalData(convert(user.getPersonalData()))
                .withDeliveryAddress(convertAddressDTOS(user.getDeliveryAddress()))
                .withLogginData(convert(user.getLogginData()))
                .withOrders(convertOrders(user.getOrders()))
                .withOperationEvidence(convertOperationEvidences(user.getOperationEvidence()))
                .withDiscountCodes(convertDiscountCodes(user.getDiscountCodes()))
                .withArchive(user.getArchive())
                .build();
    }




}
