package com.korobko;

import com.korobko.controller.UserController;
import com.korobko.dao.UserDaoImpl;
import com.korobko.service.UserServiceImpl;

import java.util.function.Function;

/**
 * Написать реализацию CRUD методов в AbstractDao, чтобы они могли работать с любыми моделями в нашем приложении.
 * <p>
 * public interface GenericDao<T> {
 * T create(T t);
 * T findById(Long id);
 * T update(T t);
 * T delete(T t);
 * }
 *
 * @author Vova Korobko
 */
public class Main {

    public static void main(String[] args) {

        UserController controller2 = (UserController) Function.identity()
                .compose(UserController::new)
                .compose(UserServiceImpl::new)
                .compose(UserDaoImpl::new)
                .apply(Factory.getConnection());

        System.out.println("");
    }
}
