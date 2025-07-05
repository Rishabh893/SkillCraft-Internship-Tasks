from PIL import Image

def encrypt_image(path):
    img = Image.open(path)
    pixels = img.load()

    for i in range(img.size[0]):
        for j in range(img.size[1]):
            r, g, b = pixels[i, j]
            pixels[i, j] = (255 - r, 255 - g, 255 - b)  # invert colors

    encrypted_path = "encrypted_" + path
    img.save(encrypted_path)
    print(f"Encrypted image saved as {encrypted_path}")

# Example usage
image_path = input("Enter image filename (with extension): ")
encrypt_image(image_path)
