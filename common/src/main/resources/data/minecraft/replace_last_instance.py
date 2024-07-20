import os

def replace_last_instance(folder_path):
    # Ensure the folder exists
    if not os.path.exists(folder_path):
        print(f"The folder {folder_path} does not exist.")
        return

    # Iterate over each file in the folder
    for filename in os.listdir(folder_path):
        file_path = os.path.join(folder_path, filename)

        # Ensure we only process files
        if os.path.isfile(file_path):
            with open(file_path, 'r') as file:
                content = file.read()

            # Find the last instance of "item"
            last_index = content.rfind('item')

            # If "item" is found in the content
            if last_index != -1:
                # Replace the last instance of "item" with "id"
                content = content[:last_index] + 'id' + content[last_index + 4:]

                # Write the modified content back to the file
                with open(file_path, 'w') as file:
                    file.write(content)
                print(f"Processed file: {filename}")
            else:
                print(f"No instance of 'item' found in file: {filename}")

if __name__ == "__main__":
    folder_path = "recipe"  # Set your folder path here
    replace_last_instance(folder_path)
