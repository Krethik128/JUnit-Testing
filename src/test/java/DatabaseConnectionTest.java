import com.gevernova.DatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
    }

    @Test
    @DisplayName("Should be disconnected by default")
    void shouldBeDisconnectedInitially() {
        assertFalse(db.isConnected(), "Database should be disconnected initially");
    }

    @Test
    @DisplayName("Should connect successfully")
    void shouldConnectSuccessfully() {
        db.connect();
        assertTrue(db.isConnected(), "Database should be connected after calling connect()");
    }

    @Test
    @DisplayName("Should disconnect successfully")
    void shouldDisconnectSuccessfully() {
        db.connect();
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected after calling disconnect()");
    }

    @Test
    @DisplayName("Should remain connected if connect() called twice")
    void shouldRemainConnectedOnRepeatedConnect() {
        db.connect();
        db.connect();
        assertTrue(db.isConnected(), "Database should stay connected after repeated connect calls");
    }

    @Test
    @DisplayName("Should remain disconnected if disconnect() called twice")
    void shouldRemainDisconnectedOnRepeatedDisconnect() {
        db.disconnect();
        db.disconnect();
        assertFalse(db.isConnected(), "Database should stay disconnected after repeated disconnect calls");
    }

    // Negative/Boundary Test Cases
    @Test
    @DisplayName("Should not be connected without calling connect()")
    void shouldNotBeConnectedWithoutConnect() {
        assertFalse(db.isConnected(), "Database should not be connected unless connect() is called");
    }

    @Test
    @DisplayName("Should stay disconnected after disconnecting from already disconnected state")
    void shouldHandleDisconnectWhenAlreadyDisconnected() {
        assertFalse(db.isConnected());
        db.disconnect(); // No error expected
        assertFalse(db.isConnected(), "Disconnecting again should not affect state");
    }

    @Test
    @DisplayName("Should switch state correctly after connect and disconnect repeatedly")
    void shouldToggleConnectionState() {
        db.connect();
        assertTrue(db.isConnected());

        db.disconnect();
        assertFalse(db.isConnected());

        db.connect();
        assertTrue(db.isConnected());

        db.disconnect();
        assertFalse(db.isConnected());
    }
}


