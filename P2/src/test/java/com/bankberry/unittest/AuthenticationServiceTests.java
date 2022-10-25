package com.bankberry.unittest;

import com.bankberry.DAOS.UserDAO;
import com.bankberry.entities.User;
import com.bankberry.services.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTests {

    @InjectMocks
    private static AuthenticationService mockAuthenticationService;

    @Mock
    private static UserDAO mockUserDAO;

    @Mock
    private User mockUser;

    @Mock
    private User mockUser2;

    @BeforeAll
    public static void setup() {
        mockUserDAO = new UserDAO();
        mockAuthenticationService = new AuthenticationService(mockUserDAO);
    }

    @BeforeEach
    public void mockData() {
        mockUser = new User(
                1,
                "Nick",
                "Kuhaneck",
                "example@gmail.com",
                "pass123",
                2,
                3
        );

        mockUser2 = new User(
                1,
                "Nick",
                "Kuhaneck",
                "example@yahoo.com",
                "pass123",
                1,
                2
        );
    }

    @Test
    public void loginTest() {
        when(mockUserDAO.getByEmail(mockUser.getEmail())).thenReturn(mockUser);
        User nu = mockAuthenticationService.userLogin(mockUser.getEmail(),mockUser.getPass());
        Assertions.assertNotNull(nu);
    }

    @Test
    public void negative_login_test() {
        when(mockUserDAO.getByEmail(mockUser.getEmail())).thenReturn(mockUser);

        mockAuthenticationService.userLogin(mockUser.getEmail(),mockUser.getPass());

        Assertions.assertNull(null,mockUser2.getEmail());
    }
}