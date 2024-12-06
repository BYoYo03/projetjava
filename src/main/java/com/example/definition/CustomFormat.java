package com.example.definition;

// Importation des outils nécessaires
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

// Classe pour personnaliser le format du logger
class CustomFormat extends Formatter {
    @Override
    public String format(LogRecord record) {
        // Personnalisation du format du logger
        return record.getLevel() + ": " + record.getMessage() + "\n";
    }
}
