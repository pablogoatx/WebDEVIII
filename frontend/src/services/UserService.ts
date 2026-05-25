import type { User } from "../models/responses/User";
import { config } from "../config";

const API_URL = `${config.api.url}/users`;

export async function getUsers(): Promise<User[]> {
  try {
    const response = await fetch(API_URL);

    if (!response.ok) {
      throw new Error("Error al obtener los usuarios");
    }

    return await response.json();
  } catch (error) {
    console.error("Error en UserService:", error);
    throw error;
  }
}