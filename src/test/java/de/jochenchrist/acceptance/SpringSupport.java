package de.jochenchrist.acceptance;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * Extend your Step Definitions with SpringSupport to have a spring context started.
 * ContextConfiguration Annotation is required for Cucumber to start Context.
 */
@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
abstract class SpringSupport {
}
