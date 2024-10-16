import psycopg2
import os
import sys
from datetime import datetime

def log_file_to_db(file_name, commit_id, author, branch):
    try:
        connection = psycopg2.connect(
            user=os.getenv('DB_USER'),
            password=os.getenv('DB_PASSWORD'),
            host=os.getenv('DB_HOST'),
            port="5432",
            database=os.getenv('DB_NAME')
        )
        cursor = connection.cursor()

        insert_query = """
            INSERT INTO file_logs (filename, commit_id, author, branch, timestamp)
            VALUES (%s, %s, %s, %s, %s);
        """
        cursor.execute(insert_query, (file_name, commit_id, author, branch, datetime.now()))

        connection.commit()
        print(f"Logged file {file_name} to database")

    except Exception as error:
        print(f"Error while connecting to database: {error}")
    finally:
        if connection:
            cursor.close()
            connection.close()

if __name__ == "__main__":
    file_name = sys.argv[1]
    commit_id = sys.argv[2]
    author = sys.argv[3]
    branch = sys.argv[4]

    log_file_to_db(file_name, commit_id, author, branch)
