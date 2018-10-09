/*
 * Copyright (C) 2009-2018 Lightbend Inc. <https://www.lightbend.com>
 */

package play.db;

import play.api.db.TransactionIsolationLevel$;

import java.sql.Connection;

/**
 * An enumeration defines of isolation level that determines the degree to which one transaction must be isolated from resource or data modifications made by other operations.
 */
public enum TransactionIsolationLevel {

    ReadUncommitted(Connection.TRANSACTION_READ_UNCOMMITTED),

    ReadCommited(Connection.TRANSACTION_READ_COMMITTED),

    RepeatedRead(Connection.TRANSACTION_REPEATABLE_READ),

    Serializable(Connection.TRANSACTION_SERIALIZABLE);

    private final int id;

    TransactionIsolationLevel(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public TransactionIsolationLevel$.Value asScala() {
        return TransactionIsolationLevel$.MODULE$.apply(id);
    }

    public static TransactionIsolationLevel fromId(final int id) {
        for (TransactionIsolationLevel type : values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }

}
