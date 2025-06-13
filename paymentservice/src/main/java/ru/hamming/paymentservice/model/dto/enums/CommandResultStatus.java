package ru.hamming.paymentservice.model.dto.enums;

import lombok.Getter;

@Getter
public enum CommandResultStatus {
    SUCCESS,
    FAILED;

    public static CommandResultStatus fromString(String command) {
        for (CommandResultStatus commandResultStatus : CommandResultStatus.values()) {
            if (commandResultStatus.toString().equalsIgnoreCase(command)) {
                return commandResultStatus;
            }
        }

        throw new IllegalStateException("Invalid CommandResultStatus" + command);
    }
}
