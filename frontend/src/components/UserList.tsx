import { useEffect, useState } from "react";
import type { User } from "../models/responses/User";
import { getUsers } from "../services/UserService";

export function UserList() {
  const [users, setUsers] = useState<User[]>([]);

  useEffect(() => {
    getUsers()
      .then((data) => setUsers(data))
      .catch((error) => console.error("Error al obtener usuarios:", error));
  }, []);

  return (
    <div>
      <h1>Lista de usuarios</h1>
      {users.map((user) => (
        <div key={user.resourceId}>
          <p>{user.name}</p>
          <p>{user.birthDate}</p>
        </div>
      ))}
    </div>
  );
}