package ru.netology;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {

    private LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    public void testLocaleRussia() {
        // Проверка локализации для России
        assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
    }

    @Test
    public void testLocaleUsa() {
        // Проверка локализации для США
        assertEquals("Welcome", localizationService.locale(Country.USA));
    }
}