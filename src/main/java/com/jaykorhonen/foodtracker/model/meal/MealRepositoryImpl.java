package com.jaykorhonen.foodtracker.model.meal;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

@Repository
@Transactional(readOnly = true)
public class MealRepositoryImpl implements MealRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Meal findByDateAndType(Date mealDate, String mealType) {
        Query query = entityManager.createNativeQuery("SELECT * FROM meal as m " +
                "WHERE m.meal_date LIKE :date AND m.meal_type LIKE :type", Meal.class);
        query.setParameter("date", mealDate).setParameter("type", mealType);
        return (Meal) query.getSingleResult();
    }
}
