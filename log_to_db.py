import mysql.connector
import os
import sys
from datetime import datetime

def log_file_to_db(file_name, commit_id, author, branch):
    try:
        # Establish the MySQL connection using environment variables
        connection = mysql.connector.connect(
            host=os.getenv("DB_HOST"),
            user=os.getenv("DB_USER"),
            password=os.getenv("DB_PASSWORD"),
            database=os.getenv("DB_NAME"),
            port=os.getenv("DB_PORT")
        )

        cursor = connection.cursor()

        # SQL query to insert file details into the table
        insert_query = """
            INSERT INTO file_logs (filename, commit_id, author, branch, timestamp)
            VALUES (%s, %s, %s, %s, %s);
        """
        cursor.execute(insert_query, (file_name, commit_id, author, branch, datetime.now()))

        # Commit the transaction to the database
        connection.commit()
        print(f"Logged file {file_name} to database")

    except mysql.connector.Error as error:
        print(f"Error while connecting to MySQL: {error}")
    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()

if __name__ == "__main__":
    # Command-line arguments from the GitLab pipeline
    file_name = sys.argv[1]
    commit_id = sys.argv[2]
    author = sys.argv[3]
    branch = sys.argv[4]

    # Call the function to log the file details to the database
    log_file_to_db(file_name, commit_id, author, branch)
