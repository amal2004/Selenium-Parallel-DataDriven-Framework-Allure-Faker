package com.amalw.tests;

import java.util.Locale;
import java.util.UUID;

import com.amalw.datagenerator.FakeDataGenerator;
import com.amalw.enums.Gender;
import com.amalw.model.User;
import com.amalw.utils.EmailUtils;

import net.datafaker.Faker;

public final class UserDataBuilder  {


    private UserDataBuilder () {
    }

    public static User generateValidUser() {

    	Faker faker = FakeDataGenerator.getFaker();
    	String password = faker.internet().password(8, 12, true, true, true);

        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(EmailUtils.generateUniqueEmail())
                .company(faker.company().name())
                .password(password)
                .confirmPassword(password)
                .build();

    }
    


}