package com.example.definition;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

// Classe pour personnaliser le format du logger
class CustomFormat extends Formatter {
    @Override
    public String format(LogRecord record) {
        // Personnalisez ici le format des messages de log
        return record.getLevel() + ": " + record.getMessage() + "\n";
    }
}
