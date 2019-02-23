
    create table Student (
        ID numeric(19,0) identity not null,
        NAME nvarchar(250) not null,
        ADDRESS nvarchar(250),
        CLASSES nvarchar(255),
        
        primary key (ID)
    );

    create unique index ID_INDEX on Student (ID ASC, NAME ASC);